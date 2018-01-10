package com.skyhuang.spring3.demo3;

/**
 * Created by hk on 2018/1/10.
 */
public class Product {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setup(){
        System.out.println("初始化方法执行...");
    }

    public void teardown(){
        System.out.println("销毁的方法执行...");
    }

    @Override
    public String toString() {
        return "Product [name=" + name + "]";
    }
}
