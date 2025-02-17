package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class QQServer {
    // 监听窗口 等待客户端的链接
    private ServerSocket serverSocket;
    private static HashMap<String, User> users = new HashMap<>(); // 合法用户
    private static HashMap<String, ArrayList<Message>> offLineMap = new HashMap<>(); //存储的离线信息

    // 静态代码块
    static {
        users.put("100", new User("100", "123456"));
        users.put("200", new User("200", "123456"));
        users.put("300", new User("300", "123456"));

    }

    public boolean isCorrect(String userid, String password) {
        return users.containsKey(userid) && users.get(userid).getPassword().equals(password);
    }

    public QQServer() {
        System.out.println("服务器端在9999端口监听");
        // 启动推送
        new Thread(new SendNewsToAllService()).start();

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

                if (isCorrect(user.getUserId(), user.getPassword())) {
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCESSED);
                    oos.writeObject(message);
                    // 加载离线信息

                    // 创建一个线程
                    ServerConnectClientThread serviceConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    serviceConnectClientThread.start();
                    //放入集合进行管理
                    ManageClientThread.add(user.getUserId(), serviceConnectClientThread);
                    if (offLineMap.containsKey(user.getUserId())) {
                        ArrayList<Message> list = offLineMap.get(user.getUserId());
                        for (Message m : list) {
                            oos.writeObject(m);
                        }
                        offLineMap.remove(user.getUserId());
                    }

                } else {
                    System.out.println("用户" + user.getUserId() + "登录失败");
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAILED);
                    oos.writeObject(message);
                    socket.close();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // 如果服务器端退出了while循环 服务器不在监听
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new QQServer();
    }
}
