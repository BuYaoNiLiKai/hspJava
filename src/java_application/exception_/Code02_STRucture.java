package java_application.exception_;

public class Code02_STRucture {
    public static void main(String[] args) {
        try {
            String name = null;
//            System.out.println(name.length());
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
