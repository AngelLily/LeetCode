package my.test;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author lishuai47
 * @date 2020/4/21 17:14
 * @description
 */
public class TestWeakHashMap {

    public static void main(String[] args) {

        Thread t = new Thread();

        HashMap<String,StringTest> hm = new HashMap<>();
        hm.put("aaa",new StringTest());

        WeakHashMap<String,StringTest> whm = new WeakHashMap<>();

        whm.put("aaa",new StringTest());

    }
}
