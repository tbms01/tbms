package com.newoxen.springcloud.tbms.admin.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 代码(XtDm)实体类
 *
 * @author makejava
 * @since 2020-06-01 11:26:54
 */
public class XtDm implements Serializable {
    private static final long serialVersionUID = -12620268983586960L;
    /**
    * 代码编号
    */
    private String dmbh;
    /**
    * 上级代码编号
    */
    private String sjdmbh;
    /**
    * 代码类别（0_系统代码,1_用户代码,系统代码固定在系统开发过程中，用户代码可以动态添加）
    */
    private String dmlb;
    /**
    * 代码分类编码
    */
    private String dmflbm;
    /**
    * 代码分类名称
    */
    private String dmflmc;
    /**
    * 代码编码
    */
    private String dmbm;
    /**
    * 代码名称
    */
    private String dmmc;
    /**
    * 显示顺序号
    */
    private Integer xssxh;
    /**
    * 代码状态（正常、停用）
    */
    private String dmzt;
    /**
    * 状态变更时间
    */
    private String ztbgsj;
    /**
    * 创建人编号
    */
    private String cjrbh;
    /**
    * 创建时间
    */
    private String cjsj;
    /**
    * 操作人编号
    */
    private String czrbh;
    /**
    * 操作时间
    */
    private String czsj;


    public String getDmbh() {
        return dmbh;
    }

    public void setDmbh(String dmbh) {
        this.dmbh = dmbh;
    }

    public String getSjdmbh() {
        return sjdmbh;
    }

    public void setSjdmbh(String sjdmbh) {
        this.sjdmbh = sjdmbh;
    }

    public String getDmlb() {
        return dmlb;
    }

    public void setDmlb(String dmlb) {
        this.dmlb = dmlb;
    }

    public String getDmflbm() {
        return dmflbm;
    }

    public void setDmflbm(String dmflbm) {
        this.dmflbm = dmflbm;
    }

    public String getDmflmc() {
        return dmflmc;
    }

    public void setDmflmc(String dmflmc) {
        this.dmflmc = dmflmc;
    }

    public String getDmbm() {
        return dmbm;
    }

    public void setDmbm(String dmbm) {
        this.dmbm = dmbm;
    }

    public String getDmmc() {
        return dmmc;
    }

    public void setDmmc(String dmmc) {
        this.dmmc = dmmc;
    }

    public Integer getXssxh() {
        return xssxh;
    }

    public void setXssxh(Integer xssxh) {
        this.xssxh = xssxh;
    }

    public String getDmzt() {
        return dmzt;
    }

    public void setDmzt(String dmzt) {
        this.dmzt = dmzt;
    }

    public String getZtbgsj() {
        return ztbgsj;
    }

    public void setZtbgsj(String ztbgsj) {
        this.ztbgsj = ztbgsj;
    }

    public String getCjrbh() {
        return cjrbh;
    }

    public void setCjrbh(String cjrbh) {
        this.cjrbh = cjrbh;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getCzrbh() {
        return czrbh;
    }

    public void setCzrbh(String czrbh) {
        this.czrbh = czrbh;
    }

    public String getCzsj() {
        return czsj;
    }

    public void setCzsj(String czsj) {
        this.czsj = czsj;
    }

}