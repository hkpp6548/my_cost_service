package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.service.UserService;
import cn.skyhuang.estore.utils.StringStaticUtils;
import cn.skyhuang.estore.utils.UuidUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/** 注册控制器
 * Created by dahoufang the one on 2017/10/28.
 */
@WebServlet(name = "RegistServlet",urlPatterns = "/regist")
public class RegistServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //设置用户的角色，注册用户全部是user
        user.setRole(StringStaticUtils.USER_ROLE);
        //设置邮件校验码
        user.setActivecode(UuidUtils.getUuid());
        UserService service = new UserService();
        try {
            service.add(user);
            response.sendRedirect(request.getContextPath()+"/regist_success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("regist.message", "注册失败" + e.getMessage());
            request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
