package net_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Code01_InetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());
        System.out.println(InetAddress.getByName("www.baidu.com"));
        System.out.println(InetAddress.getByName("Potato-2.local"));


    }
}
