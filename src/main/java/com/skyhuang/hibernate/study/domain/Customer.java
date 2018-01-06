package com.skyhuang.hibernate.study.domain;

/** 客户实体类
 * Created by hk on 2017/11/29.
 */
public class Customer {
    private Integer cid;
    private String cname;
    private Integer age;
    private Integer version;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
