package threds_;

public class Code10_Sync {
    public static void main(String[] args) {
        ST st = new ST();
        new Thread(st).start();
        new Thread(st).start();
        new Thread(st).start();


    }
}

class ST implements Runnable {
    int count = 100;
    boolean flag = true;

    public synchronized void sell() {
        System.out.println(Thread.currentThread().getName() + "售票" + --count);

        if (count <= 0) {
            System.out.println("售票结束" + Thread.currentThread().getName() + " " + count);
            flag = false;
            return;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void run() {
        while (flag) {
            sell();

        }
    }
}
