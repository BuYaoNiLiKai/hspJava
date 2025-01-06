package threds_;


import java.util.Scanner;

public class Code12_HomeWork01 {
    public static void main(String[] args) {
        T8 t8 = new T8();
        T9 t9 = new T9(t8);
        t8.start();
        t9.start();
    }
}

class T9 extends Thread {
    T8 t8;

    public T9(T8 t8) {
        this.t8 = t8;
    }

    @Override
    public void run() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("输入字符");
            char ch = sc.next().charAt(0);
            if (ch == 'Q') {
                t8.setFlag(false);
                break;
            }

        }
    }
}

class T8 extends Thread {
    boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        while (flag) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
