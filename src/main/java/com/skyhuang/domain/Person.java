package com.skyhuang.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
@XStreamAlias("person")
public class Person {

    //@XStreamAsAttribute
    private int id;
    //@XStreamAlias("姓名")
    private String name;
    //@XStreamOmitField
    private int age;

    public Person() {
        super();
    }

    public Person(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}