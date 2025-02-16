package net_;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Code05_SendImg {
    public static class MyType {
        byte[] val;
        int length;

        public MyType(byte[] val, int length) {
            this.val = val;
            this.length = length;
        }
    }

    public static void main(String[] args) {

    }

    ArrayList<MyType> getImg(String path) throws IOException {
        BufferedInputStream bis = null;
        bis = new BufferedInputStream(
                new FileInputStream(path)
        );
        ArrayList<MyType> img = new ArrayList<>();
        while (true) {
            byte[] buf = new byte[1024];
            int len;
            len = bis.read(buf);
            if (len == -1) {
                break;
            } else {
                img.add(new MyType(buf, len));
            }
        }
        System.out.println(img.size());
        return img;
    }

    @Test
    void server() throws IOException {

        ServerSocket ss = new ServerSocket(9999);

    }

    @Test
    void client() throws IOException {
        String to = "./src/img.png";
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));

    }

    @Test
    void compare() throws IOException {
        String from = "img.png";
        String to = "./src/img.png";
        ArrayList<MyType> img = getImg(from);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));
        for (MyType myType : img) {
            bos.write(myType.val, 0, myType.length);
        }
        bos.flush();
        bos.close();
    }
}
