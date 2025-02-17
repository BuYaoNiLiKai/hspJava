package qqserver.service;

import java.util.HashMap;

public class ManageClientThread {
    // 管理和客户端通信的线程
    private static HashMap<String, ServerConnectClientThread> map = new HashMap<>();

    public static HashMap<String, ServerConnectClientThread> getMap() {
        return map;
    }

    // 添加
    public static void add(String userID, ServerConnectClientThread serviceConnectClientThread) {
        map.put(userID, serviceConnectClientThread);
    }

    public static ServerConnectClientThread get(String userID) {
        return map.get(userID);
    }

    public static void remove(String userID) {
        map.remove(userID);
    }

    public static String getOnlineUsers() {
        StringBuilder res = new StringBuilder();
        for (String key : map.keySet()) {
            res.append(key).append(" ");
        }
        return res.toString();

    }
}
