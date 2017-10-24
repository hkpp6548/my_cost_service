package com.skyhuang.study.language;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**演示 ResourceBundle使用  读取配置文件
 * Created by dahoufang the one on 2017/10/24.
 */
public class ResourceBundleTest {

    @Test
    public void resourceBundleTest(){
    //ResourceBundle bundle = ResourceBundle.getBundle("message");
        ResourceBundle bundle = ResourceBundle.getBundle("login", Locale.US);
        String value = bundle.getString("title");
        System.out.println(value);
    }

}
