package com.skyhuang.struts2.study.web.controller;

import com.opensymphony.xwork2.ActionSupport;

/** Action创建方式3.创建一个类，继承自ActionSupport类.  com.opensymphony.xwork2.ActionSupport（常用）
 * Created by dahoufang the one on 2017/11/7.
 */
public class Hello3Action extends ActionSupport {

    public String execute() throws Exception {
        System.out.println("hello Hello3Action 继承ActionSupport.");
        return SUCCESS;
    }

}
