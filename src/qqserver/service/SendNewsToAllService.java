package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class SendNewsToAllService implements Runnable {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {


            System.out.println("请输入要发送的消息[exit] 退出");
            String info = scanner.next();
            if (info.equals("exit")) {
                break;
            }
            Message message = new Message();
            message.setSendTime(new Date().toString());
            message.setContent(info);
            message.setMsgType(MessageType.MESSAGE_TO_ALL);
            message.setFromUser("服务器");
            System.out.println("服务器对大家说" + info);
            HashMap<String, ServerConnectClientThread> map = ManageClientThread.getMap();
            for (String onlineUser : map.keySet()) {

                try {
                    ObjectOutputStream oos = new ObjectOutputStream(map.get(onlineUser).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
    }
}
