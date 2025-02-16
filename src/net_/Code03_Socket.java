package net_;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Code03_Socket {
    public static void main(String[] args) {


    }

    @Test
    void socketServer() throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端socket在9999端口");
        Socket socket = serverSocket.accept();
        System.out.println("监听到socket并进行配对");
        //获取客户端的输出
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
        System.out.println("接受完客户端信息");
        //像客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client".getBytes());
        socket.shutdownOutput();


        outputStream.close();

        socket.close();
        serverSocket.close();

    }

    @Test
    void socketClient() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("向服务器发送信息");
        outputStream.write("hello server".getBytes());
        socket.shutdownOutput();
        System.out.println("接受服务器信息");
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }

        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
