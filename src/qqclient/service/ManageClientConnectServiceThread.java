package qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServiceThread extends Thread {
    // 管理客户端连接到服务器端的线程类 key为用户id
    private static HashMap<String, ClientConnectServerThread> map = new HashMap<>();

    public static void add(String userId, ClientConnectServerThread clientConnectServerThread) {
        map.put(userId, clientConnectServerThread);
    }

    public static ClientConnectServerThread get(String userId) {
        return map.get(userId);
    }


}
