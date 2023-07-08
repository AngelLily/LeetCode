package my;

import lombok.Data;

/**
 * 内部类和匿名内部类测试
 * @author lishuai47
 * @since 2023/7/5
 */
@Data
public class DemoOuterClazz {

    public int num ;




    @Data
    static class  DemoInnerClazz{

        public  int innerNum;

        public void testAb(DemoNode dn){
            System.out.println("====>"+dn.getN1());
            dn.test();
        }

    }

    public static void main(String[] args) {
        DemoInnerClazz innerClazz =  new DemoInnerClazz();

        innerClazz.setInnerNum(5);

        innerClazz.testAb(new DemoNode() {
            @Override
            public void test() {
                System.out.println("===>99999999");
            }
        });


        System.out.println( "====>" + innerClazz.getInnerNum() );
    }


}

@Data
abstract class DemoNode{
    private int n1;

    public abstract void test();
}
