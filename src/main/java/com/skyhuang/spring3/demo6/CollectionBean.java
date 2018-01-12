package com.skyhuang.spring3.demo6;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/** 集合属性注入
 * Created by dahoufang the one on 2018/1/12.
 */
public class CollectionBean {
    private List<String> list;//数组和集合是一样的写法
    private Set<String> set;
    private Map<String,Integer> map;
    private Properties properties;

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionBean [list=" + list + ", set=" + set + ", map=" + map
                + ", properties=" + properties + "]";
    }
}
