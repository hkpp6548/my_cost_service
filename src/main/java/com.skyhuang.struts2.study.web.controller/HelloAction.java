package com.skyhuang.struts2.study.web.controller;

/**
 * Created by dahoufang the one on 2017/11/7.
 */
public class HelloAction {

    public String say(){
        System.out.println("访问 HelloAction。。。");
        return "good";
    }

}
