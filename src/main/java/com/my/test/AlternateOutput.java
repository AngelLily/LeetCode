package com.my.test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lishuai47
 * @date 2020/4/22 10:49
 * @description 两个线程  一个打印 1234...  另一个打印 abcd... 实现交替打印 1a2b3c4d....
 */
public class AlternateOutput {

    public static void main(String[] args) {

        final String[] arr1 = new String[]{"1","2","3","4","5","6"};
        final String[] arr2 = new String[]{"a","b","c","d","e","f"};
        AlternateOutput test =new AlternateOutput();
//        test.testWaitNotify(arr1,arr2);
//        test.testLockSupport(arr1,arr2);
//        test.testCondition(arr1,arr2);
//        test.testCondition2(arr1,arr2);
//        test.testBlockingQeue(arr1,arr2);
//        test.testSynchronousQueue(arr1,arr2);
        test.testTransferQueue(arr1,arr2);

    }


    /**
     * 使用 TransferQueue 实现
     */
    public void  testTransferQueue(String[] arr1,String[] arr2){
        TransferQueue<String> tq = new LinkedTransferQueue<>();

        new Thread(()->{
            try {
                for (String s1 : arr1){
                    System.out.print(tq.take());
                    tq.transfer(s1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (String s2 : arr2){
                    tq.transfer(s2);
                    System.out.print(tq.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 使用 SynchronousQeue 实现
     */
    public void  testSynchronousQueue(String[] arr1,String[] arr2){
        SynchronousQueue<String> sq1 = new SynchronousQueue<>();
        SynchronousQueue<String> sq2 = new SynchronousQueue<>();

        new Thread(()->{
            try {
                for (String s1 : arr1){
                    System.out.print(sq1.take());
                    sq2.put(s1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (String s2 : arr2){
                    sq1.put(s2);
                    System.out.print(sq2.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 使用 BlockingQeue 实现
     */
    public void  testBlockingQeue(String[] arr1,String[] arr2){
        BlockingQueue<String> bq1 = new LinkedBlockingDeque<>();
        BlockingQueue<String> bq2 = new LinkedBlockingDeque<>();

        new Thread(()->{
            try {
                for (String s1 : arr1){
                    System.out.print(s1);
                    bq2.put(s1);
                    bq1.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (String s2 : arr2){
                    bq2.take();
                    System.out.print(s2);
                    bq1.put(s2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 使用 Lock的 Condition 实现
     */
    public void  testCondition2(String[] arr1,String[] arr2){
        ReentrantLock lock = new ReentrantLock();
        Condition c = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for (String s1 : arr1){
                    System.out.print(s1);
                    c.signal();
                    c.await();
                }
                c.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try {
                lock.lock();
                for (String s2 : arr2) {
                    System.out.print(s2);
                    c.signal();
                    c.await();
                }
                c.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }


    /**
     * 使用 Lock的 Condition 实现
     */
    public void  testCondition(String[] arr1,String[] arr2){
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for (String s1 : arr1){
                    System.out.print(s1);
                    c2.signal();
                    c1.await();
                }
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            try {
                lock.lock();
                for (String s2 : arr2) {
                    System.out.print(s2);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }


    /**
     * 使用 LockSupport 的 park 和 unpark 实现
     */
    Thread t1 = null;
    Thread t2 = null;
    public void  testLockSupport(String[] arr1,String[] arr2){

        t1 = new Thread(()->{

            for (String s1 : arr1){
                System.out.print(s1);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"线程1");

        t2 = new Thread(()->{
            for (String s2 : arr2){
                LockSupport.park();
                System.out.print(s2);
                LockSupport.unpark(t1);
            }
        },"线程2");

        t1.start();
        t2.start();
    }

    /**
     * 使用 synchronized 和 wait notify
     */
    public void testWaitNotify(String[] arr1,String[] arr2){
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                for (String s1 : arr1){
                    try {
                        System.out.print(s1);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }
        }).start();

        new Thread(()->{
            synchronized (o){
                for (String s2 : arr2){
                    try {
                        System.out.print(s2);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notifyAll();
            }
        }).start();
    }
}
