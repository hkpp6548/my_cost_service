package cn.skyhuang.estore.utils;

import javax.servlet.http.Cookie;

/** cookie帮助类
 * Created by dahoufang the one on 2017/10/30.
 */
public class CookieUtils {

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

}
