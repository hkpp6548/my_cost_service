package com.skyhuang.utils;

import javax.servlet.http.Cookie;

/** Cookie工具类
 * Created by hk on 2017/9/12.
 */
public class CookieUtils {

    /**
     * 通过指定名称查找指定的cookie
     * @param cookies
     * @param name
     * @return
     */
    public static Cookie getCookieByName(Cookie [] cookies, String name){
        //Cookie数组不存在
        if(cookies == null){
            return null;
        }else{
            //循环遍历，查看指定的name,在Cookies中是否存在
            for (Cookie cookie: cookies) {
                // 获取cookie的名称，和name进行匹配
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
            return null;
        }
    }

}
