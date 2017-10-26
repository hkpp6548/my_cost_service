package com.skyhuang.study.designMode.proxy;

/** 被代理学生类
 * Created by dahoufang the one on 2017/10/25.
 */
public class Student implements Person{

    public String say(String message) {
        String s = "我是学生";
        System.out.println(s);
        return s;
    }

}
