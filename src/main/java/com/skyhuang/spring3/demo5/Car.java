package com.skyhuang.spring3.demo5;

/** 属性注入（构造方法注入）
 * Created hk on 2018/1/12.
 */
public class Car {

    private String name;
    private Double price;

    public Car() {
        super();
    }

    public Car(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", price=" + price + "]";
    }

}
