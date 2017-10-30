package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.LoginException;
import cn.skyhuang.estore.service.UserService;
import cn.skyhuang.estore.utils.Md5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

/** 登录
 * Created by dahoufang the one on 2017/10/30.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.得到请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        try {
            User user = service.login(username, password);
            // 判断是否勾选了记住用户名.
            String remember = request.getParameter("remember");
            if ("on".equals(remember)) {
                // 勾选了--考虑中文问题
                Cookie cookie = new Cookie("remember", URLEncoder.encode(user.getUsername(), "utf-8"));
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
            } else {
                // 如果用户没有勾选记住用户名，将cookie删除。删除cookie，只需要设置maxage=0或-1,注意：要与cookie的path一致.
                Cookie cookie = new Cookie("remember", URLEncoder.encode(user.getUsername(), "utf-8"));
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            //判断是否自动登录


            String autologin=request.getParameter("autologin");
            if("on".equals(autologin)){
                Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                        user.getUsername(), "utf-8")+"::"+password);
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
            }else{
                Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                        user.getUsername(), "utf-8")+"::"+password);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }



            request.getSession().invalidate();//先销毁session。
            request.getSession().setAttribute("user", user);// 登录成功，将user存储到session中.
            response.sendRedirect("http://localhost:8080"); // 重定向可以跳转到任意路径,请求转发只能在本站内跳转.
        } catch (LoginException e) {
            e.printStackTrace();
            request.setAttribute("login.message", e.getMessage());
            request.getRequestDispatcher("/home.jsp")
                    .forward(request, response);
            return;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
