package java_middle.interface_;

public class Test01 {
    public static void test(Interface01 interface01) {
        interface01.start();
        interface01.stop();
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        Computer computer = new Computer();
        test(phone);
        test(computer);
    }
}
