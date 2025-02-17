package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// 文件传输服务
public class FileClientService {
    public void sendFileToOne(String src, String dest, String fromUser, String toUser) {
        // 读取src文件
        Message message = new Message();
        message.setFromUser(fromUser);
        message.setToUser(toUser);
        message.setMsgType(MessageType.MESSAGE_SEND_FILE);
        message.setDest(dest);
        message.setSrc(src);

        // 读取文件
        FileInputStream fis = null;
        byte[] buffer = new byte[(int) new File(src).length()];
        try {
            fis = new FileInputStream(src);
            fis.read(buffer);
            message.setFileBytes(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        //
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    ManageClientConnectServiceThread.get(fromUser).getSocket().getOutputStream()
            );
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("发送成功");
    }
}
