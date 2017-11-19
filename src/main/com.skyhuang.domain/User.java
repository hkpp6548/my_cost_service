package com.skyhuang.domain;

import java.io.Serializable;

/** 用户实体类
 * Created by hk on 2017/11/18.
 */
public class User implements Serializable{

    private int userID;
    private String userName;
    private String logonName;
    private String logonPwd;
    private String sex;
    private String birthday;
    private String education;
    private String telephone;
    private String interest;
    private String path;
    private String filename;
    private String remark;

    private String isUpload;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", logonName='" + logonName + '\'' +
                ", logonPwd='" + logonPwd + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", education='" + education + '\'' +
                ", telephone='" + telephone + '\'' +
                ", interest='" + interest + '\'' +
                ", path='" + path + '\'' +
                ", filename='" + filename + '\'' +
                ", remark='" + remark + '\'' +
                ", isUpload='" + isUpload + '\'' +
                '}';
    }
}
