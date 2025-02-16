package net_;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Code09_HomeWork01 {
    public static void main(String[] args) throws IOException {
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
        socket.close();
    }
}
