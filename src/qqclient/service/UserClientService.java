package qqclient.service;


import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

// 用户登录验证和用户注册
public class UserClientService {
    private User user = new User();
    private Socket socket = null;

    public boolean checkUser(String userID, String password) {
        user.setUserId(userID);
        user.setPassword(password);
        boolean result = false;
        //链接服务器 发送user对象
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(user); // 发送user对象

            //读取从 服务器返回的message
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) in.readObject();
            if (message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCESSED)) {
                // 登录成功
                // 创建一个和服务器保持通信饿的线程 -> 连接类
                result = true;
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();

                ManageClientConnectServiceThread.add(userID, clientConnectServerThread);
                // 为了扩展 将线程放入到集合当中
            } else {
                // 登录失败
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void onlineUsers() {
        // 返回在线用户列表
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_GET_ONLINE_USERS);
        message.setFromUser(user.getUserId());

        // 发送给服务器
        try {
            String id = user.getUserId();
            System.out.println("userID:" + id);
            System.out.println("你好啊");
            ClientConnectServerThread clientConnectServerThread = ManageClientConnectServiceThread.get(id);
            Socket socket = clientConnectServerThread.getSocket();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("客户端发送出请求");
            out.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    // 退出客户端 并给服务器发送一个退出系统的message对象
    public void logout() {
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setFromUser(user.getUserId());
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(message);
            System.out.println("用户" + user.getUserId() + "退出系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {

    }

}
