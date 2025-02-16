package net_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Code10_HomeWork01 {
    public static void main(String[] args) throws IOException {
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
    }
}
