/*
package cn.skyhuang.estore.service;

import cn.skyhuang.estore.annotation.PrivilegeInfo;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.PrivilegeException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

*/
/**
 * Created by dahoufang the one on 2017/11/6.
 *//*

public class UserServiceFactory {

    private static UserService userService = new UserServiceImpl();

    public static UserService getInstance(){

        UserService proxyUserService = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 真实行为访问前--判断用户是否有权限执行当前行为
                // 1.得到Method方法要想访问需要的权限名称.
                PrivilegeInfo annotation = method.getAnnotation(PrivilegeInfo.class);
                if(null == annotation){ //没有注解就可以访问方法
                    return method.invoke(userService,args);
                }
                String value = annotation.value();//得到方法上的注解值
                User user = (User)args[0];//得到当前用户
                String role = user.getRole();//用户的角色
                List<String> privileges = Arrays.asList(ResourceBundle.getBundle("privilege").getString(role).split(","));
                if(!privileges.contains(value)){
                    throw new PrivilegeException("没有权限点击");
                }
                return method.invoke(userService, args);
            }
        });
        return proxyUserService;
    }

}
*/
