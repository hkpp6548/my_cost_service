package com.skyhuang.study.program.weightRecord.domain;

import java.util.Date;

/**
 * Created by dahoufang the one on 2017/9/25.
 */
public class WeightRecord {
	/** 记录id */
	private int id;
	/** 日期  */
	private Date date;
	/** 跑步前体重 */
	private double runAgoWeight;
	/** 跑步后体重 */
	private double runAfterWeight;
	/** 洗澡后体重  */
	private double bathAfterWeight;
	/** 睡觉前体重  */
	private double sleepAgoWeight;

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

	public double getRunAfterWeight() {
		return runAfterWeight;
	}

	public void setRunAfterWeight(double runAfterWeight) {
		this.runAfterWeight = runAfterWeight;
	}

	public double getBathAfterWeight() {
		return bathAfterWeight;
	}

	public void setBathAfterWeight(double bathAfterWeight) {
		this.bathAfterWeight = bathAfterWeight;
	}

	public double getSleepAgoWeight() {
		return sleepAgoWeight;
	}

	public void setSleepAgoWeight(double sleepAgoWeight) {
		this.sleepAgoWeight = sleepAgoWeight;
	}
}
