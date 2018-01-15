package com.skyhuang.spring3.demo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 注解配置Bean
 * Created by hk on 2018/1/15.
 */
@Component("testUserService")
public class TestUserServiceImpl implements TestUserService{

    @Autowired
    private UserDao userDao;

    public void sayHello() {
        System.out.println("sayHello +++++++" + userDao);
    }
}
