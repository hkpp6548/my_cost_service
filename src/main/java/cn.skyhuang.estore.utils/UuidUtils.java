package cn.skyhuang.estore.utils;

import java.util.UUID;

/** uuid帮助类
 * Created by dahoufang the one on 2017/10/28.
 */
public class UuidUtils {

    /**
     * 获取uuid
     * @return uuid
     */
    public static String getUuid(){
        return UUID.randomUUID().toString();
    }

}
