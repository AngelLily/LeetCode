package my.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
}


class ThreadTest extends Thread {

    public static void main(String[] args) {

        ThreadTest t = new ThreadTest();
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Thread.run");
    }
}

class ExecutorTest{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{

        });
    }
}


class CallableTest implements Callable {

    public static void main(String[] args) {

        CallableTest callableTest = new CallableTest();
        FutureTask ft = new FutureTask(callableTest);

        Thread thread = new Thread(ft);
        thread.start();
    }

    @Override
    public Object call() throws Exception {
        return "Callable.call";
    }
}