package com.skyhuang.study.myDatasource.zengqiang;

/** 使用继承增强
 * Created by hk on 2017/9/20.
 */
public class Demo1 {
    public static void main(String[] args) {
        Person p = new Student();
        p.eat();
    }
}

class Person{
    public void eat(){
        System.out.println("吃饭！");
    }
}

class Student extends Person{
    @Override
    public void eat(){
        super.eat();
        System.out.println("学习！");
    }
}
