package collection_;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        if ((a = b) == 20) {
            System.out.println("hello world");
        } else {
            System.out.println("bye");
        }
        System.out.println(a);
        System.out.println(b);
        int val = (int) Math.pow(2, 16) - 1;
        System.out.println(val ^ (val >>> 16));
        System.out.println(15 * 17 * 257);
    }
}
