package threds_;

public class Code07_Practice {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + Thread.currentThread().getName() + (i + 1));
            Thread.sleep(1000);
            if (i == 4) {
                t3.start();
                t3.join();

            }
        }
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + Thread.currentThread().getName() + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
