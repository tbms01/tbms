package com.newoxen.springcloud.tbms.admin.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 附件信息(XtFjxx)实体类
 *
 * @author makejava
 * @since 2020-06-01 11:31:15
 */
public class XtFjxx implements Serializable {
    private static final long serialVersionUID = 369164560709760245L;
    /**
    * 附件编号
    */
    private String fjbh;
    /**
    * 组织编码
    */
    private String zzbm;
    /**
    * 附件名称
    */
    private String fjmc;
    /**
    * 附件根目录
    */
    private String fjml;
    /**
    * 附件路径
    */
    private String fjlj;
    /**
    * 附件下载路径
    */
    private String downloadurl;
    /**
    * 后缀名
    */
    private String fjhzm;
    /**
    * 提交人编号
    */
    private String tjrbh;
    /**
    * 提交人名称
    */
    private String tjrmc;
    /**
    * 提交时间
    */
    private Date tjsj;


    public String getFjbh() {
        return fjbh;
    }

    public void setFjbh(String fjbh) {
        this.fjbh = fjbh;
    }

    public String getZzbm() {
        return zzbm;
    }

    public void setZzbm(String zzbm) {
        this.zzbm = zzbm;
    }

    public String getFjmc() {
        return fjmc;
    }

    public void setFjmc(String fjmc) {
        this.fjmc = fjmc;
    }

    public String getFjml() {
        return fjml;
    }

    public void setFjml(String fjml) {
        this.fjml = fjml;
    }

    public String getFjlj() {
        return fjlj;
    }

    public void setFjlj(String fjlj) {
        this.fjlj = fjlj;
    }

    public String getDownloadurl() {
        return downloadurl;
    }

    public void setDownloadurl(String downloadurl) {
        this.downloadurl = downloadurl;
    }

    public String getFjhzm() {
        return fjhzm;
    }

    public void setFjhzm(String fjhzm) {
        this.fjhzm = fjhzm;
    }

    public String getTjrbh() {
        return tjrbh;
    }

    public void setTjrbh(String tjrbh) {
        this.tjrbh = tjrbh;
    }

    public String getTjrmc() {
        return tjrmc;
    }

    public void setTjrmc(String tjrmc) {
        this.tjrmc = tjrmc;
    }

    public Date getTjsj() {
        return tjsj;
    }

    public void setTjsj(Date tjsj) {
        this.tjsj = tjsj;
    }

}