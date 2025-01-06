package threds_;

public class Code03_SellTickets {
    public static void main(String[] args) {
        SellTickets sellTickets = new SellTickets();
        SellTickets sellTickets1 = new SellTickets();
        SellTickets sellTickets2 = new SellTickets();
        Thread t1 = new Thread(sellTickets);
        Thread t2 = new Thread(sellTickets1);
        Thread t3 = new Thread(sellTickets2);
        t1.start();
        t2.start();
        t3.start();

    }
}

class SellTickets implements Runnable {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            System.out.println("窗口" + Thread.currentThread().getName() + ": " + --tickets);
            if (tickets <= 0) {
                System.out.println("窗口" + Thread.currentThread().getName() + ":售罄 ");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}