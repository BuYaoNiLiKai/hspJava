package qqserver.common;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private User fromUser; //发送者
    private User toUser; //接收者
    private String msg; //发送的消息
    private String sendTime;  //发送时间
    private String msgType; //信息类型

//    public Message(User fromUser, User toUser, String msg, String sendTime, String msgType) {
//        this.fromUser = fromUser;
//        this.toUser = toUser;
//        this.msg = msg;
//        this.sendTime = sendTime;
//        this.msgType = msgType;
//    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
