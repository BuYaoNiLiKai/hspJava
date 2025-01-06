package java_middle;

public class Code02_Practice02 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.shout();
        dog.shout();
    }
}

abstract class Animal {
    public abstract void shout();
}

class Dog extends Animal {

    @Override
    public void shout() {
        System.out.println("狗会汪汪叫");
    }
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("猫喵喵");
    }
}