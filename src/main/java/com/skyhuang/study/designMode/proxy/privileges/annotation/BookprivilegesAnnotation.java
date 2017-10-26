package com.skyhuang.study.designMode.proxy.privileges.annotation;

import java.lang.annotation.*;

/** 注解 （和动态代理控制权限）
 * Created by dahoufang the one on 2017/10/26.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface BookprivilegesAnnotation {

    public String value();

}
