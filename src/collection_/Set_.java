package collection_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(2);
        System.out.println(s);
        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
        for (Object o : s) {
            System.out.println(o);
        }
    }
}
