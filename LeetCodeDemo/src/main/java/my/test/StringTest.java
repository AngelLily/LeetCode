package my.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lishuai47
 * @date 2020/4/21 10:41
 * @description
 */
@Slf4j
public class StringTest {

    public static void main(String[] args) {

        StringTest t = new StringTest();
//        t.testString();
//        t.testStringBuilder();
//        t.testStringBuffr();

        StringBuilder sb1 = new StringBuilder();
        sb1.append("a");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("a");
    }


    public void testString(){
        String s = "";
        long l = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            s=s+i;
        }
        log.info("String time :{}" , System.currentTimeMillis()-l);

    }

    public void testStringBuilder(){
        StringBuilder sb = new StringBuilder();
        long l = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            sb.append(i);
        }
        log.info("StringBuilder time :{}" , System.currentTimeMillis()-l);

    }

    public void testStringBuffr(){
        StringBuffer sb = new StringBuffer();
        long l= System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            sb.append(i);
        }
        log.info("StringBuffer time :{}" , System.currentTimeMillis()-l);
    }
}
