package common_class.string_;

public class Practice02 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hello";
        Person p2 = new Person();
        p2.name = "hello";
        System.out.println(p1.equals(p2));
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name == "hello");
    }
}

class Person {
    String name;

}