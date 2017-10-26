package com.skyhuang.study.designMode.proxy.privileges.controller;

import com.skyhuang.study.designMode.proxy.privileges.factory.BookServiceFactory;
import com.skyhuang.study.designMode.proxy.privileges.service.BookPrivilegesService;
import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.study.program.weightRecord.utils.StaticStringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** bookPrivilegesServlet控制器
 * Created by dahoufang the one on 2017/10/26.
 */
@WebServlet(name = "BookPrivilegesServlet", urlPatterns = "/bookPrivilegesServlet")
public class BookPrivilegesServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        //验证用户信息
        if ("add".equalsIgnoreCase(method)) {
            add(request, response);
        } else if ("delete".equalsIgnoreCase(method)) {
            delete(request, response);
        } else if ("update".equalsIgnoreCase(method)) {
            update(request, response);
        } else if ("search".equalsIgnoreCase(method)) {
            search(request, response);
        }

    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute(StaticStringUtils.USER);
        BookPrivilegesService bookPrivilegesService = BookServiceFactory.getBookPrivilegesService();
        bookPrivilegesService.add(user);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute(StaticStringUtils.USER);
        BookPrivilegesService bookPrivilegesService = BookServiceFactory.getBookPrivilegesService();
        bookPrivilegesService.delete(user);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute(StaticStringUtils.USER);
        BookPrivilegesService bookPrivilegesService = BookServiceFactory.getBookPrivilegesService();
        bookPrivilegesService.update(user);
    }

    public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute(StaticStringUtils.USER);
        BookPrivilegesService bookPrivilegesService = BookServiceFactory.getBookPrivilegesService();
        bookPrivilegesService.search(user);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }
}
