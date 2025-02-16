package net_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Code13_HomeWork03 {
    public static void main(String[] args) throws IOException {
        // 服务器端 负责上传图片 供客户端下载
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("链接已建立");
        // 1.socket 输入流 （）
        // 2. socket 字节输出流
        // 3. 本地文件 字节输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream fis = null;
        // 查看是否存在
        String path = br.readLine();
        System.out.println("收到图片请求");
        String defaultFile = "img.png";
        if (!new File(path).exists()) {
            System.out.println("图片不存在,返回默认图片");
            path = defaultFile;
        } else {
            System.out.println("图片存在");
        }
        // 指定文件
        fis = new BufferedInputStream(new FileInputStream(path));

        // 存储到byte[] 数组中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        byte[] bytes = baos.toByteArray();

        // 写入
        bos.write(bytes);
        System.out.println("文件已上传");
        socket.shutdownOutput();


        //关闭
        bos.close();
        baos.close();
        fis.close();
        socket.close();
        serverSocket.close();


    }
}
