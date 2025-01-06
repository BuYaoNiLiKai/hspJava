package threds_;

public class Code09_State {
    public static void main(String[] args) throws InterruptedException {
        T5 t5 = new T5();
        System.out.println(t5.getState());
        t5.start();
        while (t5.getState() != Thread.State.TERMINATED) {
            System.out.println(t5.getName() + "       " + t5.getState());
            Thread.sleep(500);
        }
        System.out.println(t5.getState());
    }
}

class T5 extends Thread {
    int count = 0;

    @Override
    public void run() {
        while (count != 3) {
            System.out.println("hello world " + Thread.currentThread().getName() + "  " + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}