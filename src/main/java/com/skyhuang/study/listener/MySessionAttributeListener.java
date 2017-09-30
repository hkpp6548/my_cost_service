package com.skyhuang.study.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class MySessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		// arg0.getSession(); 获取事件源，也就是获取session对象.
		System.out.println("MySessionAttributeListener监听" + httpSessionBindingEvent.getName());
		System.out.println("MySessionAttributeListener监听" + httpSessionBindingEvent.getValue());
		System.out.println("向session中添加属性");
	}

	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("MySessionAttributeListener监听 :session移除属性");
	}

	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("MySessionAttributeListener监听 :session修改属性");
	}
}
