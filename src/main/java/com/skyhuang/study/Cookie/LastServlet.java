package com.skyhuang.study.Cookie;

import com.skyhuang.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 使用cookie记录上次的访问时间
 * Created by hk on 2017/9/12.
 */
@WebServlet(name = "LastServlet",urlPatterns = "/lastServlet")
public class LastServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 	1.获取所有的cookie，判断是否是第一次访问
         * 	2.如果是第一次访问
         * 		* 输出欢迎，记录当前的时间，回写到浏览器
         * 	3.如果不是第一次访问
         * 		* 获取时间，输出到浏览器，记录当前的时间，回写到浏览器。
         * 	记录当前的时间，回写到浏览器。
         */
        // 设置字符中文乱码问题
        response.setContentType("text/html;charset=utf-8");
        // 获取所有的cookie
        Cookie[] cookies = request.getCookies();
        // 通过指定cookie名称来查找cookie		Cookie c = new Cookie("last","当前的时间");
        Cookie last = CookieUtils.getCookieByName(cookies, "last");
        // 判断，如果cookie==null，说明是第一次访问
        if(last == null){
            // 输出欢迎，记录当前的时间，回写到浏览器
            response.getWriter().write("您好！您是第一次访问哦！");
        }else{
            // 获取cookie的值，输出浏览器，记录当前的时间，回写到浏览器
            response.getWriter().write("您好！您上次的访问时间是："+last.getValue());
        }
        // 记录当前的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strNowDate = sdf.format(new Date());
        Cookie cookie = new Cookie("last",strNowDate);
        // 回写到浏览器
        // 使用cookie回写
        response.addCookie(cookie);
    }
}
