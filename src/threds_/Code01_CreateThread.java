package threds_;

import java_base.poly.Animal;

public class Code01_CreateThread {
    public static void main(String[] args) throws InterruptedException {
//        Cat cat = new Cat();
//        cat.start();
//        Dog dog = new Dog();
//        Thread thread = new Thread(dog);
//        thread.start();
//        for (int i = 0; i < 100; i++) {
//            System.out.println("主线程从未停止" + i + Thread.currentThread().getName());
//            Thread.sleep(1000);
//        }
        ThreadProxy threadProxy = new ThreadProxy(new Tiger());
        threadProxy.start();


    }
}

class Cat extends Thread {
    @Override
    public void run() { //写上自己的业务逻辑
        int count = 0;
        while (true) {
            System.out.println("你好啊，终于学到线程了" + count++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 100) {
                break;
            }
        }

    }
}

class Dog implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("你好啊，这里是Dog类别" + count++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class Ainmal {

}

class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("tiger!!!!!!!!");
    }
}

class ThreadProxy implements Runnable {
    private Runnable target;

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start0() {
        run();
    }

    public void start() {
        start0();
    }

}