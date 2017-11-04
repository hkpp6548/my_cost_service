package cn.skyhuang.estore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 *  servlet基类
 *  透过反射自动调用向相应方法，base类
 *  子类找不到相应的service()方法会向父类寻找，找到baseServlet.service()
 *  透过调用此方法
 *  Created by dahoufang the one on 2017/11/4.
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
           /*
                1.访问http://localhost:8080/user?method=login。
                2.UserServlet中没有找到service然后去父类中找，BaseServlet.service()。
                3.this代表调用此方法的对象，实际对象是UserServlet类对象，获取方法名，然后通过反射调用UserServlet中的对应方法。
                4.请求红method=login，这个login要和方法名一致。
           */
            String methodName = req.getParameter("method");
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
