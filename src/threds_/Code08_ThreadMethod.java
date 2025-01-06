package threds_;

// 守护线程
public class Code08_ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T4 t4 = new T4();
        t4.setDaemon(true);// 先设置在启动
        t4.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "hi " + i);
            Thread.sleep(100);
        }
        // 主线程结束 子线程结束 只需设置为守护线程

    }
}

class T4 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}