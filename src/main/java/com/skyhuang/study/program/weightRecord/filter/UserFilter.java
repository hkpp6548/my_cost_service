package com.skyhuang.study.program.weightRecord.filter;

import com.skyhuang.study.program.weightRecord.utils.StaticStringUtils;
import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 用户登录过滤器
 * Created by hk on 2017/10/7.
 */
@WebFilter(filterName = "UserFilter",urlPatterns = "/weightRecord")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //不登录则为游客模式，只能查看 不能新增编辑等操作。
        //项目路径
        String contextPath = request.getContextPath();
        User userSession = (User)request.getSession().getAttribute(StaticStringUtils.USER);
        //判断session中是否有用户信息
        if(userSession == null){
            Cookie[] cookies = request.getCookies();
            Cookie userCookie = CookieUtils.getCookieByName(cookies, "user");
            //判断cookie中是否存有用户信息（自动登录）
            if(null != userCookie){
                String value = userCookie.getValue();
                String[] split = value.split(StaticStringUtils.USER_SPLIT);
                User user = new User(split[0], split[1]);
                request.getSession().setAttribute(StaticStringUtils.USER, user);
            }else {
                //没有session和cookie则重新登录
                request.getRequestDispatcher(contextPath + "/index.jsp").forward(request,response);
            }
        }
        System.out.println("weightRecord登录过滤");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
