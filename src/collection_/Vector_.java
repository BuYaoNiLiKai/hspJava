package collection_;

import java.util.LinkedList;
import java.util.Vector;

public class Vector_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        Vector v = new Vector();
        v.add("hello");
        v.add("world");
        v.add(123);
        System.out.println(v);

    }
}
