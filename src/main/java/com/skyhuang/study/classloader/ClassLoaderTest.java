package com.skyhuang.study.classloader;

import com.skyhuang.domain.City;

import javax.activation.MimeType;
import java.lang.reflect.InvocationTargetException;

/** 测试自定义类加载器
 * Created by hk on 2017/10/26.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        MimeType mt = new MimeType();//想调自己的类
//        ClassLoader classLoader = mt.getClass().getClassLoader();
//        System.out.println(classLoader);//引导类加载器


        String rootDir = City.class.getResource("/").getPath();//获取classes的磁盘路径
        System.out.println(rootDir);
        MyClassLoader mcl = new MyClassLoader(rootDir);
        try {
            Class<?> clazz = mcl.findClass("javax.activation.MimeType");
            try {
                clazz.getDeclaredMethod("show").invoke(clazz.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
