package com.skyhuang.domain;

import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
public class Province {
    private String name;

    private List<City> citys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }
}
