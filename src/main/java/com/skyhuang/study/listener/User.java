package com.skyhuang.study.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class User implements HttpSessionBindingListener,
		HttpSessionActivationListener, Serializable {

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("将user对象绑定到了session中");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("从session中将user对象移除");
	}

	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("活化");
	}

	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("钝化");
	}

}
