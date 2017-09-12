package com.skyhuang.domain;

/** 测试GsonFormat插件，从json数据中生成java类
 *  Created by dahoufang the one on 2017/9/12.
 */
public class JsonToJavaTest {

    /**
     * id : id
     * userName : hk
     * password : ****
     */

    private String id;
    private String userName;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
