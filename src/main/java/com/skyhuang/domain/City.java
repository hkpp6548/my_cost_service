package com.skyhuang.domain;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
public class City {

    public City(){

    }

    public City(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
