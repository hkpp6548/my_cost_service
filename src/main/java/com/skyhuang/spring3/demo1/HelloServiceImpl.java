package com.skyhuang.spring3.demo1;

/**
 * Created by hk on 2018/1/8.
 */
public class HelloServiceImpl implements HelloService{

    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public void sayHello() {
        System.out.println("Hello Spring..." + info);
    }

}
