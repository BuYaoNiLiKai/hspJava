package common_class.string_;

public class StringMain {
    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1.hashCode());
        s1 = "abc";
        String s2 = "abc";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        s1 = "hello";
        System.out.println(s1.hashCode());
        String s3 = new String("abc");
        System.out.println(s3.hashCode());
        System.out.println(s3 == s1);

    }
}
