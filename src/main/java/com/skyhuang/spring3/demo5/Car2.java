package com.skyhuang.spring3.demo5;

/** 属性注入（setting方法注入）
 * Created by hk on 2018/1/12.
 */
public class Car2 {
    private String name;
    private Double price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Car2 [name=" + name + ", price=" + price + "]";
    }
}
