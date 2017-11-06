package cn.skyhuang.estore.web.filter;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.LoginException;
import cn.skyhuang.estore.service.OldUserService;
import cn.skyhuang.estore.utils.CookieUtils;
import cn.skyhuang.estore.utils.StringStaticUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/** 自动登录过滤器
 * Created by dahoufang the one on 2017/10/30.
 */
@WebFilter(filterName = "AutoLoginFilter",urlPatterns = "/*")
public class AutoLoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 处理自动登录
        User user = (User) request.getSession().getAttribute("user");
        // 1.如果用户已经登录不需要自动登录
        if (user == null) {
            // 没有登录，进行自动登录
            // 2.判断访问的资源路径，例如登录，注册不需要进行自动登录
            String uri = request.getRequestURI();
            String contextPath = request.getContextPath();
            String path = uri.substring(contextPath.length());
            if (!("/regist".equals(path) || "/regist.jsp".equals(path) || "/login.jsp".equals(path) || "/logout".equals(path))) {
                // 3.得到Cookie
                Cookie cookie = CookieUtils.findCookieByName(request.getCookies(), "autologin");
                if (cookie != null) {
                    // 有cookie，进行登录操作.
                    String username = URLDecoder.decode(cookie.getValue().split("::")[0], "utf-8");
                    String password = cookie.getValue().split("::")[1];
                    OldUserService service = new OldUserService();
                    try {
                        User userTwo = service.login(username, password);
                        if (userTwo != null) {
                            request.getSession().setAttribute(StringStaticUtils.USER_ROLE_USER, userTwo);// 进行自动登录.
                        }
                    } catch (LoginException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // 放行
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }


}
