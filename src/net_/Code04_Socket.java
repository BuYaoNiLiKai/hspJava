package net_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Code04_Socket {
    public static void main(String[] args) {

    }

    @Test
    void socketServer() throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端socket在9999端口");
        Socket socket = serverSocket.accept();
        System.out.println("监听到socket并进行配对");

        //获取客户端的输出
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello  client");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();

    }

    @Test
    void socketClient() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        System.out.println("向服务器发送信息");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello server");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        System.out.println("接受服务器信息");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        socket.close();
    }
}
