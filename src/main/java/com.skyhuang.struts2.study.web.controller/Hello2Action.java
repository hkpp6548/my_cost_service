package com.skyhuang.struts2.study.web.controller;

import com.opensymphony.xwork2.Action;

/** Action创建方式2.创建一个类，实现Action接口.  com.opensymphony.xwork2.Action
 * Created by dahoufang the one on 2017/11/7.
 */
public class Hello2Action implements Action{

    public String execute() throws Exception {
        System.out.println("hello Hello2Action 实现Action.");
        //return "success";
        return SUCCESS;
    }

}
