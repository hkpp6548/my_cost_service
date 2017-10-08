package com.skyhuang.study.program.weightRecord.domain;

/** 用户信息实体类
 * Created by hk on 2017/10/6.
 */
public class User {

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
