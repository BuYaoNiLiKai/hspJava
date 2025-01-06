package java_application.exception_;

public class Code03_CustomException {
    public static void main(String[] args) {
        int age = 1;
        if (!(age >= 18 && age >= 120)) {
            throw new AgeException("年龄有错误");
        }
        System.out.println("你的年龄是正常的");
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}