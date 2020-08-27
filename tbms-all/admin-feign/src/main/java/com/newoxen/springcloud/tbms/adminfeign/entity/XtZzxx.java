package com.newoxen.springcloud.tbms.adminfeign.entity;

import java.io.Serializable;

/**
 * 组织信息(XtZzxx)实体类
 *
 * @author makejava
 * @since 2020-06-01 11:29:42
 */
public class XtZzxx implements Serializable {
    private static final long serialVersionUID = 794880786402406635L;
    /**
    * 组织编码
    */
    private String zzbm;
    /**
    * 组织名称
    */
    private String zzmc;
    /**
    * 组织简称
    */
    private String zzjc;
    /**
    * 组织地址
    */
    private String zzdz;
    /**
    * 交易系统编号
    */
    private String jyxtbh;
    /**
    * 上级组织编码（直接上级）
    */
    private String sjzzbm;
    /**
    * 所属单位编码（单位标志为是的组织编码）
    */
    private String ssdwbm;
    /**
    * 单位标志（0、单位 1、部门）
    */
    private String dwbz;
    /**
    * 申购结算标志（是、否，申购结算标志为是，才可以将用电客户挂在这个组织编码下）
    */
    private String sgjsbz;
    /**
    * 办公电话号码
    */
    private String bgdhhm;
    /**
    * 传真号码
    */
    private String czhm;
    /**
    * 显示顺序号
    */
    private Integer xssxh;
    /**
    * 组织状态代码（正常、停用、锁定等）
    */
    private String zzztdm;
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


    public String getZzbm() {
        return zzbm;
    }

    public void setZzbm(String zzbm) {
        this.zzbm = zzbm;
    }

    public String getZzmc() {
        return zzmc;
    }

    public void setZzmc(String zzmc) {
        this.zzmc = zzmc;
    }

    public String getZzjc() {
        return zzjc;
    }

    public void setZzjc(String zzjc) {
        this.zzjc = zzjc;
    }

    public String getZzdz() {
        return zzdz;
    }

    public void setZzdz(String zzdz) {
        this.zzdz = zzdz;
    }

    public String getJyxtbh() {
        return jyxtbh;
    }

    public void setJyxtbh(String jyxtbh) {
        this.jyxtbh = jyxtbh;
    }

    public String getSjzzbm() {
        return sjzzbm;
    }

    public void setSjzzbm(String sjzzbm) {
        this.sjzzbm = sjzzbm;
    }

    public String getSsdwbm() {
        return ssdwbm;
    }

    public void setSsdwbm(String ssdwbm) {
        this.ssdwbm = ssdwbm;
    }

    public String getDwbz() {
        return dwbz;
    }

    public void setDwbz(String dwbz) {
        this.dwbz = dwbz;
    }

    public String getSgjsbz() {
        return sgjsbz;
    }

    public void setSgjsbz(String sgjsbz) {
        this.sgjsbz = sgjsbz;
    }

    public String getBgdhhm() {
        return bgdhhm;
    }

    public void setBgdhhm(String bgdhhm) {
        this.bgdhhm = bgdhhm;
    }

    public String getCzhm() {
        return czhm;
    }

    public void setCzhm(String czhm) {
        this.czhm = czhm;
    }

    public Integer getXssxh() {
        return xssxh;
    }

    public void setXssxh(Integer xssxh) {
        this.xssxh = xssxh;
    }

    public String getZzztdm() {
        return zzztdm;
    }

    public void setZzztdm(String zzztdm) {
        this.zzztdm = zzztdm;
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