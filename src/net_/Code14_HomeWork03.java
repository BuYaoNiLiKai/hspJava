package net_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Code14_HomeWork03 {
    public static void main(String[] args) throws IOException {
        // 建立连接
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        // 要下载的图片
        String img = "img.png";
        // 保存路径
        String path = "./src/" + img;
        //  向服务器端发送要下载的图片
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(img);
        bw.newLine();
        bw.flush();

        System.out.println("图片请求已经发送");

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(path));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = bis.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        baos.flush();
        byte[] data = baos.toByteArray();
        fos.write(data);


        baos.close();
        fos.close();
        bis.close();
        bw.close();
        socket.close();

        System.out.println("图片已保存");
    }
}
