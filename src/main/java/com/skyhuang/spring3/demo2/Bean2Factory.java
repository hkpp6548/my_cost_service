package com.skyhuang.spring3.demo2;

/** Bean2的静态工厂
 * Created by hk on 2018/1/9.
 */
public class Bean2Factory {

    public static Bean2 getBean2(){
        System.out.println("静态工厂的获得Bean2的方法...");
        return new Bean2();
    }

}
