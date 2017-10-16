package com.skyhuang.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 日期时间帮助类
 * Created by dahoufang the one on 2017/10/16.
 */
public class DateUtils {

    private static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间的规定格式的Date。
     * @return
     */
    public static Date getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        String format = sdf.format(new Date());
        try {
            Date parse = sdf.parse(format);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static void main(String[] args) {
        System.out.println(getNowDate().toString());
    }*/



}
