package net_;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Code02_Socket {
    public static void main(String[] args) {

        Socket socket = null;

    }

    @Test
    void socketServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听，等待链接");
        // 阻塞
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();

    }

    @Test
    void socketClient() throws IOException {
        System.out.println("客户端");
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
