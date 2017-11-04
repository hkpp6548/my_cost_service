package cn.skyhuang.estore.web.servlet.old2;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.ActiveCodeException;
import cn.skyhuang.estore.exception.LoginException;
import cn.skyhuang.estore.exception.RegistException;
import cn.skyhuang.estore.service.UserService;
import cn.skyhuang.estore.utils.CookieUtils;
import cn.skyhuang.estore.utils.RequestSendUtiles;
import cn.skyhuang.estore.utils.StringStaticUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/** 用户相关控制器（注册，登录，注销，激活）
 * Created by dahoufang the one on 2017/11/2.
 */
/*@WebServlet(name = "OldUserServlet", urlPatterns = "old2/user")
public class OldUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String method = request.getParameter(StringStaticUtils.PARAM_METHOD);
            if("regist".equals(method)){        //注册
                regist(request, response);
            } else if ("login".equals(method)){ //登录
                login(request, response);
            } else if ("loginOut".equals(method)){  //注销
                loginOut(request, response);
            } else if ("active".equals(method)){    //激活
                active(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    *//**
     *  用户激活
     * @param request
     * @param response
     * @throws IOException
     *//*
    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String activeCode = request.getParameter("activeCode");
        UserService service = new UserService();
        //激活用户
        try {
            service.activeUser(activeCode);
            response.getWriter().write("激活成功，请回<a href='" + StringStaticUtils.HOME_PATH + "'>首页</a>");
            return;
        } catch (SQLException e) {
            throw new ActiveCodeException();
        }
    }

    *//**
     *  用户注销
     * @param request
     * @param response
     * @throws IOException
     *//*
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 注销功能就是销毁session
        request.getSession().invalidate();
        // 将自动登录的cookie删除。
        Cookie cookie = new Cookie("autologin", "");
        CookieUtils.setCookieMin0(cookie, response);
        RequestSendUtiles.requestRedirect("index.jsp", request, response);
    }

    *//**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *//*
    public void regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //验证码校验
        String checkcode = request.getParameter("checkcode");
        String checkcode_session = (String)request.getSession().getAttribute(StringStaticUtils.SESSION_CHECKCODE);
        request.getSession().removeAttribute(StringStaticUtils.SESSION_CHECKCODE);//从session中删除。
        if(!checkcode.equals(checkcode_session)){   //checkcode_session session中可能会过时
            request.setAttribute(StringStaticUtils.SESSION_CHECKCODE, "验证码错误！");
            RequestSendUtiles.requestForward(StringStaticUtils.JSP_REGIST, request, response);
            return;
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
            RequestSendUtiles.requestRedirect(StringStaticUtils.JSP_REGIST, request, response);
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
                RequestSendUtiles.requestForward(StringStaticUtils.JSP_REGIST, request, response);
                return;
            }
            //用户注册
            service.regist(user);
            //注册成功重定向到成功页面
            RequestSendUtiles.requestRedirect("regist_success.jsp", request, response);
        } catch (RegistException e) {
            e.printStackTrace();
            //捕获抛出的自定义注册异常，并返回到注册页面
            request.setAttribute("regist.message", e.getMessage());
            RequestSendUtiles.requestForward(StringStaticUtils.JSP_REGIST, request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    *//**
     *  用户登录
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     *//*
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 1.得到请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserService();
        try {
            //  验证用户，用户不正确将抛出异常
            User user = service.login(username, password);
            // 用户验证成功，判断是否勾选了记住用户名.
            String remember = request.getParameter(StringStaticUtils.COOKIE_REMEMBER);
            //  对用户名进行编码加密考虑中文问题
            String UserName = URLEncoder.encode(user.getUsername(), "utf-8");
            Cookie cookieRemeber = new Cookie(StringStaticUtils.COOKIE_REMEMBER, UserName);
            if ("on".equals(remember)) {
                // 勾选了--考虑中文问题
                CookieUtils.setCookieMax(cookieRemeber, response);
            } else {
                CookieUtils.setCookieMin0(cookieRemeber, response);
            }

            //判断是否自动登录
            String autologin = request.getParameter(StringStaticUtils.COOKIE_AUTOLOGIN);
            Cookie cookieAutologin = new Cookie(StringStaticUtils.COOKIE_AUTOLOGIN, URLEncoder.encode(
                    user.getUsername(), "utf-8")+"::"+password);
            if("on".equals(autologin)){
                CookieUtils.setCookieMax(cookieAutologin, response);
            }else{
                CookieUtils.setCookieMin0(cookieAutologin, response);
            }
            request.getSession().invalidate();//先销毁session,防止同一个浏览器登录不同用户时显示问题
            request.getSession().setAttribute("user", user);// 登录成功，将user存储到session中.
            response.sendRedirect(StringStaticUtils.HOME_PATH); // 重定向可以跳转到任意路径,请求转发只能在本站内跳转.
        } catch (LoginException e) {
            e.printStackTrace();
            request.setAttribute("login.message", e.getMessage());
            RequestSendUtiles.requestForward("home.jsp", request, response);
            return;
        }
    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}*/
