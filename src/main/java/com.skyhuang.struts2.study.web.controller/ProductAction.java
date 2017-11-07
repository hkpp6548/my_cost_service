package com.skyhuang.struts2.study.web.controller;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport {

	public String add() {

		System.out.println("product  add");
		return NONE;
	}

	public String update() {

		System.out.println("product  update");
		return NONE;
	}

	public String delete() {

		System.out.println("product  delete");
		return NONE;
	}

	public String search() {

		System.out.println("product  search");
		return NONE;
	}
}
