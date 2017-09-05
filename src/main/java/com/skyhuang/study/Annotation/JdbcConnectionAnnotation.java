package com.skyhuang.study.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 自定义注解jdbc连接注解 使用详见JdbcUtils.getConnectionByAnnotation()方法。
 * Created by hk on 2017/9/5.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JdbcConnectionAnnotation {

    //有默认值
    /*public String driverClass() default "com.mysql.jdbc.Driver";
    public String url() default "jdbc:mysql://localhost:3306/testone?useSSL=false&characterEncoding=utf-8";
    public String userName() default "root";
    public String password() default "root";*/

    //没有默认值，使用直接时可以获取
    public String driverClass();
    public String url();
    public String userName();
    public String password();
}
