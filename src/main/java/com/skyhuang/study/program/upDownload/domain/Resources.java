package com.skyhuang.study.program.upDownload.domain;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Date;

/** 上传文件类
 * Created by dahoufang the one on 2017/10/16.
 */
public class Resources {

    public Resources(){

    }

    public Resources(String uuidname, String realname, String savepath, Date uploadtime, String description){
        this.uuidname = uuidname;
        this.realname = realname;
        this.savepath = savepath;
        this.uploadtime = uploadtime;
        this.description = description;
    }

    private int id;
    /** 随机名称 */
    private String uuidname;
    /** 文件真实名字 */
    private String realname;
    /** 文件存储路径 */
    private String savepath;
    /** 上传时间 */
    private Date uploadtime;
    /** 描述 */
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuidname() {
        return uuidname;
    }

    public void setUuidname(String uuidname) {
        this.uuidname = uuidname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
