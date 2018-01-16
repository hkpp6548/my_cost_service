package com.skyhuang.struts2.study.web.controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 *	访问测试相关
 */
public class BookAction extends ActionSupport {

	public String add() {

		System.out.println("book  add");
		return NONE;
	}

	public String update() {

		System.out.println("book  update");
		return NONE;
	}

	public String delete() {

		System.out.println("book  delete");
		return NONE;
	}

	public String search() {

		System.out.println("book  search");
		return NONE;
	}

}
