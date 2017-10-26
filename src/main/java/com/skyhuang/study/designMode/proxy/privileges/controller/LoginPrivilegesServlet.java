package com.skyhuang.study.designMode.proxy.privileges.controller;

import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import com.skyhuang.study.program.weightRecord.utils.StaticStringUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/** 动态代理和注解实现细粒度权限控制
 * Created by dahoufang the one on 2017/10/26.
 */
@WebServlet(name = "LoginPrivilegesServlet",urlPatterns = "/loginPrivilegesServlet")
public class LoginPrivilegesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        WeightRecordService service = new WeightRecordService();

        try {
            User user1 = service.selectUserByUsernameAndPassword(user);
            if(user1 != null){
                request.getSession().setAttribute(StaticStringUtils.USER, user1);
                response.sendRedirect(request.getContextPath()+"/study/designMode/privileges/book.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
