package com.skyhuang.study.program.cost.domain;

import java.util.Date;

/** 收支实体类
 * Created by dahoufang the one on 2017/11/22.
 */
public class Cost {

    /** 记录id */
    private int id;
    /** 日期  */
    private Date date;
    /** 支出还是收入   0：支出 1：收入  */
    private int incomeAndOutType;
    /** 花费类型 */
    private String costType;
    /** 金额 */
    private double money;
    /** 备注 */
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIncomeAndOutType() {
        return incomeAndOutType;
    }

    public void setIncomeAndOutType(int incomeAndOutType) {
        this.incomeAndOutType = incomeAndOutType;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

}
