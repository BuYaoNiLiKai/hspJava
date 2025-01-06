package common_class.string_;

public class Practice03 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = s1 + s2;
        String s4 = "helloworld";
        System.out.println(s3 == s4);
        String s5 = "hello" + "world";
        System.out.println(s4 == s5);
        StringBuffer sb = new StringBuffer("hello");
        sb.replace(0, 2, "world");
        System.out.println(sb.toString());
        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.length());
        String s = null;
        sb1.append(s);
        System.out.println(sb1.length());
        System.out.println(sb1);
//        StringBuffer sb2 = new StringBuffer(s);
    }
}
