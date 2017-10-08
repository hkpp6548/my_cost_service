package com.skyhuang.study.program.weightRecord.controller;

import com.skyhuang.study.program.weightRecord.utils.StaticStringUtils;
import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/** 用户登录控制器
 * Created by hk on 2017/10/6.
 */
@WebServlet(name = "WRLoginServlet",urlPatterns = "/wrlogin")
public class WRLoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        try {
            //将post信息装换成user实体类
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        WeightRecordService service = new WeightRecordService();
        String contextPath = request.getContextPath();
        try {
            User user1 = service.selectUserByUsernameAndPassword(user);
            if(null != user1){
                //登录成功,将用户信息放入session中
                HttpSession session = request.getSession();
                User sessionUser = (User)session.getAttribute(StaticStringUtils.USER);
                if(null == sessionUser){
                    session.setAttribute(StaticStringUtils.USER,user);
                }
                //是否自动登录
                String autoLogin = request.getParameter("autoLogin");
                if(StringUtils.isNotEmpty(autoLogin)){
                    //自动登录则将用户名密码放入cookie中
                    Cookie cookie = new Cookie(StaticStringUtils.USER,"username=" + user.getUsername()+ StaticStringUtils.USER_SPLIT + "password="+ user.getPassword());
                    cookie.setMaxAge(60*60*24*7);
                    response.addCookie(cookie);
                }
                response.sendRedirect(contextPath + "/program/weightRecord/index.jsp");

            }else {//登录失败
                request.setAttribute("message","用户名或密码错误");
                request.getRequestDispatcher(contextPath + "/index.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            request.setAttribute("message","用户名或密码错误");
            request.getRequestDispatcher(contextPath + "/index.jsp").forward(request,response);
            e.printStackTrace();
        }

    }
}
