package com.skyhuang.struts2.study.web.controller;

/** Action类的创建方式 1.创建一个POJO类.
 * Created by dahoufang the one on 2017/11/7.
 */
public class HelloAction {

    public String say(){
        System.out.println("访问 HelloAction。。。");
        return "good";
    }

}
