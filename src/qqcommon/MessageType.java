package qqcommon;

public interface MessageType {
    String MESSAGE_LOGIN_SUCCESSED = "1"; //登录成功
    String MESSAGE_LOGIN_FAILED = "2"; //登录失败
    String MESSAGE_COMMON = "3"; //普通信息
    String MESSAGE_GET_ONLINE_USERS = "4";  //返回在线用户列表
    String MESSAGE_RETURN_ONLINE_USERS = "5";
    String MESSAGE_CLIENT_EXIT = "6"; // 客户端请求退出
    String MESSAGE_TO_ALL = "7";// 群发消息
    String MESSAGE_SEND_FILE = "8";// 发送文件
}
