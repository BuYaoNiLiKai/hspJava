package common_class;

import java.util.Scanner;

public class ReverseString {
    public static String reverseString(String str, int start, int end) {
        char[] arr = str.toCharArray();
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }

    public static void registerInfo() {
        Scanner sc = new Scanner(System.in);
        String name;
        String password;
        String email;
        System.out.println("Enter your name:");
        name = sc.nextLine();
        if (name.length() < 2 || name.length() > 4) {
            throw new RuntimeException("name长度在2~4");
        }

        System.out.println("Enter your password:");
        password = sc.nextLine();
        if (password.length() != 6) {
            throw new RuntimeException("长度有误");
        }

        for (int i = 0; i < password.length(); i++) {
            if (!(Character.isDigit(password.charAt(i)))) {
                throw new RuntimeException("密码必须是全数字");
            }
        }


        System.out.println("Enter your email:");
        email = sc.nextLine();
        int firstIndex = email.indexOf('@');
        int lastIndex = email.lastIndexOf('.');
        if (firstIndex < 0 || lastIndex < 0 || firstIndex > lastIndex) {
            throw new RuntimeException("邮箱输入有误");
        }
        System.out.println("注册成功");
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg", 1, 4));
        registerInfo();


    }
}




