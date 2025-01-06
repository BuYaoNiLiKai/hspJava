package java_middle.interface_;

public class Computer implements Interface01 {
    @Override
    public void start() {
        System.out.println("Computer started");
    }

    @Override
    public void stop() {
        System.out.println("Computer stopped");

    }
}
