package java_application.exception_;

public class Code01_Rumen {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int res = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("hello");

    }
}
