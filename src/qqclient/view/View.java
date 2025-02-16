package qqclient.view;

import qqclient.service.UserClientService;

import java.util.Scanner;

public class View {
    private UserClientService userClientService = new UserClientService();// 用于登录服务器

    void startMenu() {
        int choice = 0;
        String id;
        String password;
        Scanner sc = new Scanner(System.in);
        while (choice != 9) {
            System.out.println("==========欢迎登陆网络通信系统============");
            System.out.println("\t\t\t1 登录系统");
            System.out.println("\t\t\t9 退出系统");
            System.out.println("请输入你的选择");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    boolean success = true;
                    System.out.println("请输入用户号");
                    id = sc.next();
                    System.out.println("请输入密 码");
                    password = sc.next();
                    success = userClientService.checkUser(id, password);
                    // 验证用户是否对应密码
                    System.out.println("==========欢迎" + id + "用户============");
                    if (success) {
                        loginMenu(id);
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出系统");


    }

    // 登录成功界面
    void loginMenu(String user) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 9) {
            System.out.println("==========网络通信系统二级菜单(用户" + user + ")============");
            System.out.println("\t\t\t1 显示在线用户列表");
            System.out.println("\t\t\t2 群发消息");
            System.out.println("\t\t\t3 私聊信息");
            System.out.println("\t\t\t4 发送文件");
            System.out.println("\t\t\t9 退出系统");
            System.out.println("请输入你的选择");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("====当前在线用户列表");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    break;
                default:
                    break;
            }

        }

    }

    public static void main(String[] args) {
        new View().startMenu();
    }
}
