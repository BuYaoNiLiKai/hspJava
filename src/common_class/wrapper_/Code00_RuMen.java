package common_class.wrapper_;

public class Code00_RuMen {
    public static void main(String[] args) {

        int a = 1;
        Integer i = Integer.valueOf(a);
        System.out.println(a);
        int b = i.intValue();
        System.out.println(b);
        Object obj = true ? new Integer(5) : new Double(0.0);
        System.out.println(obj);
    }
}
