package my;

/**
 * @author lishuai47
 * @since 2023/6/14
 */
public class TestDemo {

    public void testBasic(){

        Integer i1 = 111;
        Integer i2 = 111;
        Integer i3 = 222;
        Integer i4 = 222;

        Integer i5 = new Integer(111);
        Integer i6 = new Integer(222);

        System.out.println("i1==i2 >" + (i1 == i2));
        System.out.println("i3==i4 >" + (i3 == i4));
        System.out.println("i1==i5 >" + (i1 == i5));
        System.out.println("i3==i6 >" + (i3 == i6));

    }


    public static void main(String[] args) {
        TestDemo t = new TestDemo();
        t.testBasic();
    }
}



