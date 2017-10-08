package com.skyhuang.study.program.weightRecord.utils;

import com.skyhuang.study.program.weightRecord.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 验证用户session帮助类
 * Created by hk on 2017/10/8.
 */
public class CheckSessionUser {

    /**
     * 当session中没有user用户信息时，跳转到登录页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证用户信息
        User user = (User)request.getSession().getAttribute(StaticStringUtils.USER);
        if(user == null){
            request.setAttribute("message","用户信息失效，请重新登录！");
            String contextPath = getProgramPath(request);
            request.getRequestDispatcher(contextPath + "/index.jsp").forward(request,response);
        }
    }

    /**
     * 获取项目地址路径
     * @param request
     * @return
     */
    public static String getProgramPath(HttpServletRequest request){
        return request.getContextPath();
    }

}
