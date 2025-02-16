package qqclient.service;

import qqclient.common.Message;
import qqclient.common.MessageType;
import qqclient.common.User;

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
                new ClientConnectServerThread(socket).start();
                // 为了扩展 将线程放入到集合当中
            } else {
                // 登录失败
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
