package com.skyhuang.study.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class MyServletContextListener implements ServletContextListener {

	public List<HttpSession> sessions = Collections.synchronizedList(new ArrayList<HttpSession>());// 线程安全的List集合.

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("MyServletContextListener监听：ServletContext创建");
		// 这个方法执行了，就说明项目启动了.
		// 1.得到ServletContext对象
		ServletContext servletContext = servletContextEvent.getServletContext();
		// 2,将集合保存到context中.
		servletContext.setAttribute("sessions", sessions);
		Timer t = new Timer();
		// 3.开始扫描
		/*t.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("开始扫描任务！");
				Iterator<HttpSession> iterator = sessions.iterator();
				while (iterator.hasNext()){
					HttpSession next = iterator.next();
					if(System.currentTimeMillis() - next.getLastAccessedTime() > 10000){
						System.out.println(next.getId() + " 已经超时，被销毁了。");
						iterator.remove();//从集合中移除
						next.invalidate();// 销毁session
					}
				}
			}
		},1000,2000);*/
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("MyServletContextListener监听：ServletContext销毁");
	}
}
