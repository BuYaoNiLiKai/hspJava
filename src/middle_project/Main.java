package middle_project;

import java.util.Stack;

public class Main {
    boolean isPair(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '{' && b == '}') ||
                (a == '[' && b == ']');
    }

    public static void hello() {
        System.out.println("hello");
    }

    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.a);
        System.out.println(A.a);
        a.a = 100;
        System.out.println(a.a);
        System.out.println(A.a);
        Main.hello();
    }
}

class A {
    public static int a = 10;
}