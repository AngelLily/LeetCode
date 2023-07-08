package my;

import my.demo.domain.DemoUsualDomain;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author lishuai47
 * @since 2023/7/8
 */
public class DemoUnsafe {

    /**
     * 获取Unsafe
     */
    private static Unsafe getUnsafe(){

        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            return (Unsafe) unsafe.get(null);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        DemoUnsafe demoUnsafe = new DemoUnsafe();

        demoUnsafe.testInstance();
    }

    public void testInstance() throws Exception{
        DemoUsualDomain o = (DemoUsualDomain) Objects.requireNonNull(DemoUnsafe.getUnsafe()).allocateInstance(DemoUsualDomain.class);
        o.print();
        o.printObject();
    }

}
