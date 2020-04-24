package my.test;

public  class SynchronizedTest {

    private static int i = 0;

    public static synchronized void add(){
        i++;
    }

    public synchronized void addTwo(){
        i+=2;
    }


    public static void main(String[] args) {

        SynchronizedTest  st =new SynchronizedTest();
        Thread t1 =new Thread(()->{
            for (int d = 0;d<10000;d++)
                st.addTwo();
        });

        Thread t2 =new Thread(()->{
            for (int d = 0;d<10000;d++)
                st.add();
        });

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(st.i);
    }

}



