package threds_;

public class Code06_ThreadYield {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "world" + "  " + i);
            Thread.sleep(1000);
            if (i == 5) {
                System.out.println("主线程让出cpu");
                t2.join();
            }
        }

    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "hello  " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
