package com.skyhuang.study.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 清楚product的浏览记录
 * Created by hk on 2017/9/13.
 */
@WebServlet(name = "RemoveProductServlet",urlPatterns = "/cookie/remove")
public class RemoveProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookie
        //创建cookie
        Cookie cookie = new Cookie("product","");
        //设置有效时间
        cookie.setMaxAge(0);
        //如果之前设置了有效路径，这里也需要设置有效路径
        cookie.setPath("/cookie");
        //回写cookie
        response.addCookie(cookie);
        //重定向到商品页面
        response.sendRedirect("/cookie/productList.jsp");
    }
}
