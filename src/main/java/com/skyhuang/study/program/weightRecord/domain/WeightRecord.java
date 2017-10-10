package com.skyhuang.study.program.weightRecord.domain;

import java.util.Date;

/**	体重实体类
 * Created by dahoufang the one on 2017/9/25.
 */
public class WeightRecord {
	/** 记录id */
	private int id;
	/** 日期  */
	private Date date;
	/** 跑步前体重（斤） */
	private double runAgoWeight;
	/** 洗澡后体重（斤） */
	private double bathAfterWeight;
	/** 是否跑步 */
	private int isRun;
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

	public double getRunAgoWeight() {
		return runAgoWeight;
	}

	public void setRunAgoWeight(double runAgoWeight) {
		this.runAgoWeight = runAgoWeight;
	}

	public double getBathAfterWeight() {
		return bathAfterWeight;
	}

	public void setBathAfterWeight(double bathAfterWeight) {
		this.bathAfterWeight = bathAfterWeight;
	}

	public int getIsRun() {
		return isRun;
	}

	public void setIsRun(int isRun) {
		this.isRun = isRun;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
