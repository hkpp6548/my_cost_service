package cn.skyhuang.estore.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/** cookie帮助类
 * Created by dahoufang the one on 2017/10/30.
 */
public class CookieUtils {

    /**
     *  根据名字查找cookie
     * @param cs
     * @param name
     * @return
     */
    public static Cookie findCookieByName(Cookie[] cs, String name) {
        if (cs == null || cs.length == 0) {
            return null;
        }
        for (Cookie c : cs) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    /**
     * 设置cookie的相关信息（有效路径，最大有效时间 10天）
     * @param cookie
     * @param response
     */
    public static void setCookieMax(Cookie cookie, HttpServletResponse response){
        cookie.setPath("/");
        cookie.setMaxAge(StringStaticUtils.COOKIE_MAXDAY_10);
        response.addCookie(cookie);
    }

    /**
     * 设置cookie的相关信息（有效路径，取消cookie）
     * @param cookie
     * @param response
     */
    public static void setCookieMin0(Cookie cookie, HttpServletResponse response){
        cookie.setPath("/");
        cookie.setMaxAge(StringStaticUtils.COOKIE_MAXDAY_0);
        response.addCookie(cookie);
    }

}
