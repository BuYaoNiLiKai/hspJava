package java_middle.interface_;

public class Phone implements Interface01 {
    @Override
    public void start() {
        System.out.println("Phone is running");
    }

    @Override
    public void stop() {
        System.out.println("Phone is stopped");

    }
}
