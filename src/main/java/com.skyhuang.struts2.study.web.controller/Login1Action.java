package com.skyhuang.struts2.study.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//获取请求参数  属性驱动  第一种，直接将action做为model
public class Login1Action extends ActionSupport {

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

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 2.判断用户名与密码是否正确
		if ("tom".equals(username) && "123".equals(password)) {
			request.getSession().setAttribute("username", username);
			return SUCCESS;
		} else {
			request.setAttribute("message", "用户名或密码错误");
			return "failer";
		}
	}
}
