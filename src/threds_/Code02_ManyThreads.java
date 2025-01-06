package threds_;

//多线程
public class Code02_ManyThreads {
    public static void main(String[] args) {

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread1);
        Thread t2 = new Thread(myThread2);
        t1.start();
        t2.start();
    }
}

class MyThread1 implements Runnable {

    int count = 5;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class MyThread2 implements Runnable {
    int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("world ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}