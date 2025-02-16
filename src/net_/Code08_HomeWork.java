package net_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Code08_HomeWork {
    public static void main(String[] args) {

    }

    @Test
    void work1Server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("链接建立");
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line = null;
        while (!(line = bufferedReader.readLine()).equals("exit")) {
            System.out.println(line);
            String reply = "";
            if (line.equals("name")) {
                reply = "宗培超";
            } else if (line.equals("hobby")) {
                reply = "编写java";

            } else {
                reply = "I dont know";
            }
            bufferedWriter.write(reply);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }

    @Test
    void work1Client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = null;
        do {
            System.out.println("请输入要发送的信息");
            Scanner s = new Scanner(System.in);
            line = s.nextLine();

            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println("发送完毕");
            String reply = bufferedReader.readLine();
            System.out.println(reply);
        } while (!line.equals("exit"));
        bufferedWriter.close();
        bufferedReader.close();

        socket.close();
    }
}
