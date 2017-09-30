package com.skyhuang.study.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class MyRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		System.out.println("MyRequestListener监听request创建");
	}

	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		System.out.println("MyRequestListener监听request销毁");
	}
}
