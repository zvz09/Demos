package com.zvz.velocity;

/**
 * Created by lilipo on 2017/5/11.
 */
public class UserInfo {
    private String userId;
    private String userName;
    private String address;
    public UserInfo(String userId, String userName, String address) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.address = address;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

