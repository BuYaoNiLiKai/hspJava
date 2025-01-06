package threds_;

import static java.lang.Thread.sleep;

public class Code13_HomeWork02 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread t1 = new Thread(card);
        Thread t2 = new Thread(card);
        t1.start();
        t2.start();
    }
}

class Card implements Runnable {
    int totalMoney = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (totalMoney <= 0) {
                    System.out.println("无法取钱");
                    System.out.println(totalMoney);
                    break;
                }
                totalMoney -= 100;
                System.out.println(Thread.currentThread().getName() + "取走100，余额为" + totalMoney);
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}