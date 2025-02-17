package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;


public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        // 后台通信
        while (true) {

            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // 判断message的类型
                if (message.getMsgType().equals(MessageType.MESSAGE_RETURN_ONLINE_USERS)) {
                    // 取出在线列表
                    System.out.println("服务器返回信息");
                    String[] onlineUsers = message.getContent().split(" ");
                    for (String onlineUser : onlineUsers) {
                        System.out.println("用户:" + onlineUser);
                    }
                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMMON)) {
                    System.out.println("\n" + message.getFromUser() + "对" + message.getToUser() + "说" + message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_TO_ALL)) {

                    System.out.println("\n" + message.getFromUser() + "对大家说" + message.getContent());
                } else if (message.getMsgType().equals(MessageType.MESSAGE_SEND_FILE)) {
                    System.out.println("\n" + message.getFromUser() + "给" + message.getToUser() + "发送文件" + message.getDest());
                    FileOutputStream fos = new FileOutputStream(message.getDest());
                    System.out.println(message.getFileBytes() == null);
                    fos.write(message.getFileBytes());
                    fos.close();
                    System.out.println("保存文件成功");
                } else {
                    System.out.println("其他消息暂时不处理");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
