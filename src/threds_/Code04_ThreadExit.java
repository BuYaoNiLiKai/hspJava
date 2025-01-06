package threds_;

public class Code04_ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        // 通知方式
        Thread.sleep(10000);
        t.setFlag(false);

    }
}

class T extends Thread {
    boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 1;
        while (flag) {
            System.out.println("hello" + i++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
