package com.skyhuang.utils;

import java.util.UUID;

/**
 * Created by hk on 2017/11/18.
 */
public class FileUploadUtils {
    //得到随机名
    public static String getUUIDFileName(String filename){
        int index=filename.lastIndexOf(".");

        return UUID.randomUUID()+filename.substring(index);
    }
}
