package qqserver.service;

import qqserver.common.Message;
import qqserver.common.MessageType;
import qqserver.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
    // 监听窗口 等待客户端的链接
    private ServerSocket serverSocket;

    public QQServer() {
        System.out.println("服务器端在9999端口监听");

        try {
            serverSocket = new ServerSocket(9999);
            while (true) {
                // 因为会有多个客户端
                Socket socket = serverSocket.accept();
                System.out.println("监听到一个客户端连接请求");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User) ois.readObject();
                // 服务器验证
                Message message = new Message();
                if (user.getUserId().equals("100") && user.getPassword().equals("123456")) {
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCESSED);
                } else {
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAILED);
                }
                oos.writeObject(message);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


    }
}
