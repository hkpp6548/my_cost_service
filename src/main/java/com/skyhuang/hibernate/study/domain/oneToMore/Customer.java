package com.skyhuang.hibernate.study.domain.oneToMore;

import java.util.HashSet;
import java.util.Set;

/** 客户实体
 * Created by dahoufang the one on 2017/12/27.
 */
public class Customer {
    private Integer cid;
    private String cname;
    // 一个客户有多个订单.
    private Set<Order> orders = new HashSet<Order>();
    public Integer getCid() {
        return cid;
    }
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
