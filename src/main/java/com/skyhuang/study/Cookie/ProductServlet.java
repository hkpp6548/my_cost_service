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
@WebServlet(name = "ProductServlet",urlPatterns = "/cookie/product")
public class ProductServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有cookie
        Cookie[] requestCookies = request.getCookies();
        //指定cookie名称
        String cookieName = "product";
        //获取页面参数
        String id = request.getParameter("id");
        //查看指定cookie是否存在
        Cookie cookie = CookieUtils.getCookieByName(requestCookies, cookieName);
        //指定cookie不存在
        if(cookie == null){
            //新建cookie
            Cookie newCookie =  new Cookie(cookieName,id);
            //设置有效路径
            newCookie.setPath("/cookie");
            //设置有效时间
            newCookie.setMaxAge(7*24*60*60);
            //回写cookie
            response.addCookie(newCookie);
        }else{
            //不是第一次访问 获取cookeie 的值
            String value = cookie.getValue();
            //判断当前的商品是否在value中，
            String[] ids = value.split(",");
            //不包含
            if(!ckeckIsContain(ids, id)){
                //在value中继续添加
                value = value +  "," + id;
            }
            //设置有效时间
            cookie.setMaxAge(7*24*60*60);
            //重新设置cookie的值
            cookie.setValue(value);
            //设置cookie的有效路径
            cookie.setPath("/cookie");
            //回写cookie
            response.addCookie(cookie);
        }
        //重定向到商品页面
        response.sendRedirect("/cookie/productList.jsp");
    }

    /**
     * 判断当前的name 是否在String数组中
     * @param strings
     * @param name
     * @return
     */
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
