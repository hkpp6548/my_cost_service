package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.RegistException;
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
import java.util.HashMap;
import java.util.Map;

/**
 * 注册控制器
 * Created by dahoufang the one on 2017/10/28.
 */
@WebServlet(name = "RegistServlet", urlPatterns = "/regist")
public class RegistServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码校验
        String checkcode = request.getParameter("checkcode");
        String checkcode_session = (String)request.getSession().getAttribute("checkcode_session");
        if(!checkcode.equals(checkcode_session)){//checkcode_session session中可能会过时
            request.setAttribute("checkcode_message", "验证码错误！");
            request.getRequestDispatcher(request.getContextPath() + "/regist.jsp").forward(request, response);
        }

        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //服务器端校验，防止不经过页面直接访问servlet时的问题。
        Map<String, String> map = user.validation();
        if (map.size() != 0) {
            request.setAttribute("map", map);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        UserService service = new UserService();

        try {
            User isExitsUser = service.selectUserByUsername(user);
            if(isExitsUser != null){
                Map<String, String> maps = new HashMap<String, String>();
                maps.put("regist.username.error", "用户名已存在！");
                request.setAttribute("map", maps);
                request.getRequestDispatcher("/regist.jsp").forward(request, response);
                return;
            }
            service.regist(user);
            response.sendRedirect(request.getContextPath() + "/regist_success.jsp");
        } catch (RegistException e) {
            e.printStackTrace();
            request.setAttribute("regist.message", e.getMessage());
            request.getRequestDispatcher(request.getContextPath() + "/regist.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
