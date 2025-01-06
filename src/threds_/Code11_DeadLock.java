package threds_;

import java.util.Comparator;

public class Code11_DeadLock {
    public static class MyComparator implements Comparator<Double> {

        @Override
        public int compare(Double o1, Double o2) {
            return (int) (o2 - o1);
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock(false);
        DeadLock deadLock2 = new DeadLock(true);
        Thread t1 = new Thread(deadLock);
        Thread t2 = new Thread(deadLock2);
        t1.start();
        t2.start();
    }
}

class DeadLock implements Runnable {
    static Object lock1 = new Object();
    static Object lock2 = new Object();
    boolean flag = true;

    DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "进入了lock1方法");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "从1进入2");
                }
            }
        } else {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "进入了lock2");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "从2进入1");
                }
            }
        }

    }
}