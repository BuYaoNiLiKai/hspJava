package qqclient.view;

import qqclient.service.FileClientService;
import qqclient.service.ManageClientConnectServiceThread;
import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;

import java.util.Scanner;

public class View {
    private UserClientService userClientService = new UserClientService();// 用于登录服务器
    private MessageClientService messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();

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
                    if (success) {
                        System.out.println("==========欢迎" + id + "用户============");
                        loginMenu(id, userClientService);
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 2:
                    break;
                case 9:

                default:
                    break;
            }

        }
        System.out.println("退出系统");

    }

    // 登录成功界面
    void loginMenu(String user, UserClientService userClientService) {
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
                    System.out.println("====当前在线用户列表=====");
                    userClientService.onlineUsers();
                    break;
                case 2:
                    System.out.println("请输入要跟大家说的话");
                    String string = sc.next();
                    messageClientService.sentMessageToAll(user, string);

                    break;
                case 3:
                    System.out.println("请输入想要聊天的用户号，必须在线");
                    String toUser = sc.next();
                    System.out.println("请输入想说的话");
                    String content = sc.next();
                    if (ManageClientConnectServiceThread.get(toUser) != null) {
                        messageClientService.sentMessageToOne(user, toUser, content);
                    } else {

                    }

                    break;
                case 4:
                    System.out.println("请输入要发给谁");
                    String to = sc.next();
                    System.out.println("请输入发送的文件");
                    String src = sc.next();
                    System.out.println("请输入发送到对方的路径");
                    String dest = sc.next();
                    fileClientService.sendFileToOne(src, dest, user, to);
                    break;

                case 9:
                    userClientService.logout();
                    break;
                default:
                    break;
            }

        }

    }


    public static void main(String[] args) {
        new View().startMenu();
        System.out.println("退出系统了！！！！");
    }
}
