package cn.skyhuang.estore.web.servlet.old;

import cn.skyhuang.estore.exception.ActiveCodeException;
import cn.skyhuang.estore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/** 激活控制器
 * Created by dahoufang the one on 2017/10/30.
 */
@WebServlet(name = "ActiveUserServlet",urlPatterns = "/activeUser")
public class ActiveUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String activeCode = request.getParameter("activeCode");
        UserService service = new UserService();
        //激活用户
        try {
            service.activeUser(activeCode);
            response.getWriter().write("激活成功，请回<a href='http://localhost:8080'>首页</a>");
            return;
        } catch (SQLException e) {
            throw new ActiveCodeException();
        }*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
