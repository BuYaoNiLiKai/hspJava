package java_middle;

public class Code04_Practice04 {


    public static void main(String[] args) {
        A a = new A("hello");
        a.f("world");

    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public void f(String s) {
        class B {

            private String name;

            public B(String name) {
                this.name = name;
            }

            public void show() {
                System.out.println(A.this.name);
                System.out.println(name);

            }
        }
        B b = new B(s);
        b.show();
    }
}