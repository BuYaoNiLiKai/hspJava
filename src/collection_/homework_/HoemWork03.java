package collection_.homework_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HoemWork03 {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        Set set = m.keySet();
        Iterator iterator = set.iterator();

        m.put("jack", 2600);
        System.out.println(m.get("jack"));
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            m.put(key, (Integer) m.get(key) + 100);
        }
        System.out.println(set);
        System.out.println(m.values());
        TreeSet treeSet = new TreeSet();

    }
}

