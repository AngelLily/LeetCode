package com.my.test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lishuai47
 * @date 2020/4/20 09:54
 * @description
 */
public class LockDemo {

    public static void main(String[] args) {


//        Lock lock = new ReentrantLock();
//        lock.lock();
//
//        lock.unlock();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        lock.readLock().lock();

        lock.readLock().unlock();
//        lock.

    }

}
