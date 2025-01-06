package threds_;

public class Code05_ThreadMethod1 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("Potato");
        t1.setPriority(1);
        t1.start();
        Thread.sleep(1000 * 5);
        System.out.println(t1.getPriority());
        System.out.println(t1.getName());
        t1.interrupt();

    }
}

class T1 extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "正常运行" + i);
            }
            try {
                System.out.println("程序休眠中");
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                System.out.println("线程被打断");
//                throw new RuntimeException(e);
            }
        }

    }
}