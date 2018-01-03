package com.skyhuang.hibernate.study.domain.oneToMore;

/** 订单的实体
 * Created by dahoufang the one on 2017/12/27.
 */
public class Order {
    private Integer oid;
    private String addr;
    // 订单属于某一个客户.放置一个客户的对象.
    private Customer customer;
    public Integer getOid() {
        return oid;
    }
    public void setOid(Integer oid) {
        this.oid = oid;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", addr='" + addr + '\'' +
                '}';
    }
}
