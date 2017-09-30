package com.skyhuang.study.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**用于监听session对象创建，如果创建了，将其保存到一个集合中。
 * Created by dahoufang the one on 2017/9/30.
 */
public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("MyHttpSessionListener监听session的创建");
		// session创建了.
		// 1.得到session
		HttpSession session = httpSessionEvent.getSession();
		// 2.将session保存到集合中.
		// 集合是在ServletContext中存储的，我们只需要从ServletContext中获取就可以。
		ServletContext servletContext = session.getServletContext();
		List<HttpSession> sessions = (List<HttpSession>)servletContext.getAttribute("sessions");
		sessions.add(session);
		System.out.println(session.getId() + " 添加到了集合");
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("MyHttpSessionListener监听session的销毁");
	}
}
