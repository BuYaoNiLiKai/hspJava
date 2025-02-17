package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userID; //连接到服务器端的用户id

    public ServerConnectClientThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("服务器端与客户端保持通信，" + userID + "读取客户端信息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_USERS)) {
                    // 客户端请求获取在线用户列表
                    System.out.println("客户端" + message.getFromUser() + "请求获取在线用户列表");
                    String onlineUsers = ManageClientThread.getOnlineUsers();
                    // 返回构建message对象
                    Message returnMessage = new Message();
                    returnMessage.setMsgType(MessageType.MESSAGE_RETURN_ONLINE_USERS);
                    returnMessage.setContent(onlineUsers);
                    returnMessage.setToUser(message.getFromUser());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(returnMessage);

                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMMON)) {
                    // 根据message 转发消息
                    if (ManageClientThread.getMap().containsKey(message.getToUser())) {
                        ServerConnectClientThread serverConnectClientThread = ManageClientThread.get(message.getToUser());
                        ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                        oos.writeObject(message);// 如果用户不在线可以留言
                    } else {


                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_TO_ALL)) {
                    // 遍历在线的数组
                    HashMap<String, ServerConnectClientThread> map = ManageClientThread.getMap();
                    for (String onlineUser : map.keySet()) {
                        if (!onlineUser.equals(message.getFromUser())) {
                            System.out.println("onlineUser:" + onlineUser + "fromUser:" + message.getFromUser());
                            ObjectOutputStream oos = new ObjectOutputStream(map.get(onlineUser).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }

                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_SEND_FILE)) {
                    //获取对应的线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThread.get(message.getFromUser());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getFromUser() + "退出");
                    //在 维持的集合中移除
                    sleep(1);
                    ManageClientThread.remove(userID);
                    socket.close();
                    break;


                } else {
                    System.out.println("不做处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
