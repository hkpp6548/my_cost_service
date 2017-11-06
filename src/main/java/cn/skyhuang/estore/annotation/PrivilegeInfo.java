package cn.skyhuang.estore.annotation;

import java.lang.annotation.*;

/** 自定义注解：权限控制
 * Created by dahoufang the one on 2017/11/6.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface PrivilegeInfo {

    public String value();

 }
