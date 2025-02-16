package net_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Code11_homeWork02 {
    public static void main(String[] args) throws IOException {

        // 接收端A
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];

        String info;
        do {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            info = new String(packet.getData(), 0, packet.getLength());
            System.out.println("收到提问:");
            System.out.println(info);
            byte[] data;
            if (info.equals("四大名著是哪些?")) {
                data = "四大名著是 红楼梦、三国、西游记、水浒传".getBytes();
            } else {
                data = "what".getBytes();
            }
            packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 9998);
            socket.send(packet);
            System.out.println("已回答");


        } while (!info.equals("exist"));
        System.out.println("程序退出");
        socket.close();


    }


}
