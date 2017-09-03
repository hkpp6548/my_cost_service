package com.skyhuang.domain;

/**
 * Created by hk on 2017/9/2.
 */
public class user {
    /**  记录id */
    private int id;
    /**  用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** email */
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
