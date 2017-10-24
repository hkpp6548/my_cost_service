package com.skyhuang.study.language;

import org.junit.Test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dahoufang the one on 2017/10/24.
 */
public class Demo {
    // 请创建一个date对象，并把date对象中表示日期部分的时间值，以及表示时间部分的时间值，分别以short、long模式进行格式化输出（国家设置为中国）。

    @Test
    public void fun1() {
        Date date = new Date();

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                DateFormat.LONG);

        System.out.println(df.format(date));

    }

    // 请将时间值：09-11-28 上午10时25分39秒 CST，反向解析成一个date对象。

    @Test
    public void fun2() throws ParseException {
        String s = "09-11-28 上午10时25分39秒 CST";

        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                DateFormat.LONG);
        Date date = df.parse(s);

        System.out.println(date);
    }

    // 请将整数198，输出为货币形式：$198，并将$198反向解析成整数198。
    @Test
    public void fun3() throws ParseException {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        nf.setMaximumFractionDigits(0);
        String s = nf.format(198);

        System.out.println(s);

        int n = nf.parse(s).intValue();

        System.out.println(n);
    }

    // 请将0.78654321，输出百分比格式，保留两位小数
    @Test
    public void fun4() {
        double d = 0.78654321;
        NumberFormat nf = NumberFormat.getPercentInstance();

        nf.setMinimumFractionDigits(2);

        System.out.println(nf.format(d));
    }
}
