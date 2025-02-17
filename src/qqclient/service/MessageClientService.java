package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class MessageClientService {
    //提供消息相关的方法
    public void sentMessageToOne(String fromUser, String toUser, String content) {
        Message message = new Message();
        message.setFromUser(fromUser);
        message.setToUser(toUser);
        message.setContent(content);
        message.setMsgType(MessageType.MESSAGE_COMMON);
        message.setSendTime(new Date().toString());
        System.out.println(fromUser + "对" + toUser + content + "说" + content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServiceThread.get(fromUser).getSocket().getOutputStream());
            oos.writeObject(message);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sentMessageToAll(String fromUser, String content) {
        Message message = new Message();
        message.setContent(content);
        message.setFromUser(fromUser);
        message.setMsgType(MessageType.MESSAGE_TO_ALL);
        message.setSendTime(new Date().toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServiceThread.get(fromUser).getSocket().getOutputStream());
            oos.writeObject(message);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
