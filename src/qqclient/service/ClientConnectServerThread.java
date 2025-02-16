package qqclient.service;

import qqclient.common.Message;

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
                System.out.println("客户端线程，等待从服务器端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
