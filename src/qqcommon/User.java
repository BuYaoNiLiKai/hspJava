package qqcommon;

import java.io.Serializable;

public class User implements Serializable {
    // 为了保证兼容性
    private static final long serialVersionUID = 1L;
    private String userId; //用户ID

    private String password; // 用户密码

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
