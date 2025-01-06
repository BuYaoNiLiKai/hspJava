package java_base;

import java.util.Scanner;

public class Code00_VarParamater {
    public int fun1(int q, int b) {
        return q + b;
    }

    // java中的可变参数
    public static int sum(int n1, int n2) {
        return n1 + n2;
    }

    public static int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }
}

class Test {
    int age;
    String name;

    public Test(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void f1() {
        this.f2();
    }

    void f2() {
        System.out.println("hello");
    }

}

class T {
    public T() {
        this("jack", 18);
        System.out.println("hello" + "这是无参构造方法");

    }

    public T(String name, int age) {
        System.out.println("执行了有参构造方法");
        System.out.println(name + " " + age);

    }

    public Double getMax() {
        return null;
    }
}
