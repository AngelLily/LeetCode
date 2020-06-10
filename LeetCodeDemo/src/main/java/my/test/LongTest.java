package my.test;

/**
 * @author lishuai47
 * @date 2020/4/28 15:40
 * @description
 */
public class LongTest {

    static long l = 1l;

    public static void main(String[] args) {

        new  Thread(()->{
            while ( true) {
                l = 1l;
            }
        }).start();

        new  Thread(()->{
            while ( true) {
                l = -1l;
            }
        }).start();


        new  Thread(()->{
            System.out.println("虚拟机版本："+System.getProperty("sun.arch.data.model"));
            if (l !=1 && l!=-1){
                System.out.println("aaaaaaaaaa");
            }
        }).start();

    }
}
