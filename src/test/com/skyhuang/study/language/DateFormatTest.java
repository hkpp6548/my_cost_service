package com.skyhuang.study.language;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dahoufang the one on 2017/10/24.
 */
public class DateFormatTest {
    // 无参数
    @Test
    public void fun1() {
        DateFormat df1 = DateFormat.getDateInstance(); // 只有年月日

        DateFormat df2 = DateFormat.getTimeInstance(); // 只有小时分钟秒

        DateFormat df3 = DateFormat.getDateTimeInstance();// 两个都有

        Date date = new Date();

        System.out.println(df1.format(date));
        System.out.println(df2.format(date));
        System.out.println(df3.format(date));
    }

    // 有参数构造，指定样式

    @Test
    public void fun2() {
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL); // 只有年月日

        DateFormat df2 = DateFormat.getTimeInstance(DateFormat.MEDIUM); // 只有小时分钟秒

        DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.SHORT);// 两个都有

        Date date = new Date();

        System.out.println(df1.format(date));
        System.out.println(df2.format(date));
        System.out.println(df3.format(date));
    }

    // 国际化的格式
    @Test
    public void fun3() {
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, Locale.US); // 只有年月日

        DateFormat df2 = DateFormat.getTimeInstance(DateFormat.MEDIUM,
                Locale.US); // 只有小时分钟秒

        DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.SHORT, Locale.US);// 两个都有

        Date date = new Date();

        System.out.println(df1.format(date));
        System.out.println(df2.format(date));
        System.out.println(df3.format(date));
    }

    // 关于parse方法
    @Test
    public void fun4() throws ParseException {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);// 两个都有

        Date date = new Date();

        System.out.println(df.format(date)); //2014-12-14 11:41:28

        String st="2014-12-14 11:41:28";

        Date d = df.parse(st);

        System.out.println(d);
    }
}
