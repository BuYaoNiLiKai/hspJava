package net_;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Code07_UDP {
    public static void main(String[] args) {

    }

    @Test
    void UDPA() throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        String message = "明天吃火锅";
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length,
                InetAddress.getByName("127.0.0.1"), 9999);
        socket.send(packet);

        byte[] buffer = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet2);
        System.out.println("发送端接收到信息");
        System.out.println(new String(packet2.getData(), 0, packet2.getLength()));
        socket.close();
        System.out.println("发送端退出");


    }

    @Test
    void UDPB() throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端等待接收消息");
        socket.receive(packet);
        System.out.println("接收到消息");
        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);


        byte[] mess = "好的，明天见".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(mess, mess.length, InetAddress.getByName("127.0.0.1"), 9998);
        socket.send(datagramPacket);
        System.out.println("接收端发送完信息");
        socket.close();
        System.out.println("接收端退出");
    }
}
