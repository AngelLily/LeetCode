package my.demo.domain;

import lombok.Data;

/**
 * @author lishuai47
 * @since 2023/7/8
 */
@Data
public class DemoUsualDomain {
    private int no;
    private String str;

    public void print(){
        System.out.println("笑了笑了=_=");
    }

    public void printObject(){
        System.out.println("Obj: "+ this);
    }

    @Override
    public String toString(){
        return "no=" + no +"; str=" +str +";";
    }
}
