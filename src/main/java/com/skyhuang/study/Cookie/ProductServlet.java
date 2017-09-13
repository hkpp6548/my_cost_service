package com.skyhuang.study.Cookie;

import com.skyhuang.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 使用Cookie记录商品浏览记录，浏览的只记录一次
 * Created by hk on 2017/9/13.
 */
@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] requestCookies = request.getCookies();
        String cookieName = "product";
        String id = request.getParameter("id");
        Cookie cookie = CookieUtils.getCookieByName(requestCookies, cookieName);
        if(cookie == null){
            response.addCookie(new Cookie(cookieName,id));
        }else{
            String value = cookie.getValue();
            String[] ids = value.split(",");
            if(!ckeckIsContain(ids, id)){
                value = value +  "," + id;
            }
            response.addCookie(new Cookie(cookieName, value));
        }
        //重定向到商品页面
        response.sendRedirect("/cookie/productList.jsp");
    }

    public static boolean ckeckIsContain(String [] strings, String name){
        if(strings == null){
            return false;
        }else {
            for (String str: strings) {
                if(str.equals(name)){
                    return true;
                }
            }
            return false;
        }
    }
}
