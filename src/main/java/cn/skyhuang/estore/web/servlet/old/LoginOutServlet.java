package cn.skyhuang.estore.web.servlet.old;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 注销  (未重构)
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "LoginOutServlet", urlPatterns = "/old/loginOut")
public class LoginOutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* // 注销功能就是销毁session
        request.getSession().invalidate();
        // 将自动登录的cookie删除。
        Cookie cookie = new Cookie("autologin", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath() + "/index.jsp");*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
