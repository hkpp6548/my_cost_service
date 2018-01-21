package com.skyhuang.spring3.aop_proxy.jdk_proxy;

/**
 * Created by hk on 2018/1/16.
 */
public class UserDaoImpl implements UserDao{
    public void add() {
        System.out.println("添加用户。。。");
    }

    public void update() {
        System.out.println("更新用户。。。");
    }
}
