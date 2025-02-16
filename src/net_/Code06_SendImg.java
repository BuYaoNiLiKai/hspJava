package net_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Code06_SendImg {
    public static void main(String[] args) {

    }

    @Test
    void serverSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("socket建立");
        String img = "./src/img.png";
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(img));

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = bis.read(buffer)) != -1) {
            System.out.println("正在下载图片");
            bos.write(buffer, 0, len);
        }
        bos.flush();
        System.out.println("下载完成");

        bw.write("收到图片");
        bw.flush();

        socket.shutdownOutput();


        bos.close();
        bw.close();
        bis.close();
        socket.close();
        serverSocket.close();


    }

    @Test
    void clientSocket() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        String img = "img.png";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(img));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            System.out.println("图片正在上传");
            bos.write(bytes, 0, len);
            System.out.println("等待客户端接收这一部分");
        }
        bos.flush();
        socket.shutdownOutput();


        System.out.println("上传成功");
        System.out.println(br.readLine());
        br.close();
        bos.close();
        bis.close();
        socket.close();


    }
}
