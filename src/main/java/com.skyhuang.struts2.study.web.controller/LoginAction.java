package com.skyhuang.struts2.study.web.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hk on 2017/11/7.
 */
public class LoginAction extends ActionSupport{

    public String login(){
        System.out.println("LoginAction login...");
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("skyhuang".equals(username) && "123456".equals(password)){
            request.getSession().setAttribute("username","skyhuang");
            //request.setAttribute("username","skyhuang");
            return SUCCESS;
        }else {
            request.setAttribute("message","用户名或密码错误！");
            return "login";
        }
    }

}
