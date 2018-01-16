package com.skyhuang.spring3.demo8.servlet;

import com.opensymphony.xwork2.ActionSupport;
import com.skyhuang.spring3.demo8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static org.apache.struts2.ServletActionContext.getServletContext;

/**
 * Created by dahoufang the one on 2018/1/16.
 */
@Controller
public class TestAction extends ActionSupport{

    public String add() {
        System.out.println("test  spring servlet");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        //WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
        return NONE;
    }

    public String find() {
        System.out.println("test  spring servlet  123");
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
        return NONE;
    }

}
