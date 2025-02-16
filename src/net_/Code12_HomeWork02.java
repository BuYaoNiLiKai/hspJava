package net_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Code12_HomeWork02 {
    public static void main(String[] args) throws IOException {
        // 发送端
        DatagramSocket socket = new DatagramSocket(9998);
        String question;
        Scanner scanner = new Scanner(System.in);
        do {
            question = scanner.nextLine();
            System.out.println(question);
            byte[] bytes = question.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 9999);
            socket.send(packet);
            System.out.println("问题已经提出");
            byte[] buffer = new byte[1024];
            DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet2);
            String answer = new String(packet2.getData(), 0, packet2.getLength());
            System.out.println(answer);
            System.out.println("收到回复");

        } while (!question.equals("exist"));

    }
}
