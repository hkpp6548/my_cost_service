package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.RegistException;
import cn.skyhuang.estore.service.UserService;
import cn.skyhuang.estore.utils.StringStaticUtils;
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
 * Created by dahoufang the one on 2017/11/2.
 */
@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter(StringStaticUtils.PARAM_METHOD);
        if("regist".equals(method)){

        }

    }

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码校验
        String checkcode = request.getParameter("checkcode");
        String checkcode_session = (String)request.getSession().getAttribute("checkcode_session");
        request.getSession().removeAttribute("checkcode_session");//从session中删除。
        if(!checkcode.equals(checkcode_session)){//checkcode_session session中可能会过时
            request.setAttribute("checkcode_message", "验证码错误！");
            request.getRequestDispatcher(request.getContextPath() + "/regist.jsp").forward(request, response);
        }
        //获取表单提交的数据
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());//表单转换成实体类
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //服务器端校验是否为空，防止不经过页面直接访问servlet时的问题。
        Map<String, String> map = user.validation();
        if (map.size() != 0) {
            request.setAttribute("map", map);
            request.getRequestDispatcher(request.getContextPath() + "/regist.jsp").forward(request, response);
            return;
        }
        UserService service = new UserService();
        try {
            //检验用户名是否存在（可用ajax校验）
            User isExitsUser = service.selectUserByUsername(user);
            if(isExitsUser != null){
                Map<String, String> maps = new HashMap<String, String>();
                maps.put("regist.username.error", "用户名已存在！");
                request.setAttribute("map", maps);
                request.getRequestDispatcher(request.getContextPath() + "/regist.jsp").forward(request, response);
                return;
            }
            //用户注册
            service.regist(user);
            //注册成功跳转成功页面
            response.sendRedirect(request.getContextPath() + "/regist_success.jsp");
        } catch (RegistException e) {
            e.printStackTrace();
            //捕获抛出的自定义注册异常，并返回到注册页面
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
