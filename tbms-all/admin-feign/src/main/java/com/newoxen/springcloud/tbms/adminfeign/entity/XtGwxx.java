package com.newoxen.springcloud.tbms.adminfeign.entity;

import java.io.Serializable;

/**
 * 角色信息(XtGwxx)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public class XtGwxx implements Serializable {
    private static final long serialVersionUID = -56728690359650148L;
    /**
    * 岗位编号
    */
    private String gwbh;
    /**
    * 组织编码
    */
    private String zzbm;
    /**
     * 组织名称
     */
    private String zzmc;
    /**
    * 岗位名称
    */
    private String gwmc;
    /**
    * 岗位描述
    */
    private String gwms;
    /**
    * 岗位用途代码
    */
    private String gwytdm;
    /**
    * 岗位状态代码
    */
    private String gwztdm;
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


    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh;
    }

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

    public String getGwmc() {
        return gwmc;
    }

    public void setGwmc(String gwmc) {
        this.gwmc = gwmc;
    }

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms;
    }

    public String getGwytdm() {
        return gwytdm;
    }

    public void setGwytdm(String gwytdm) {
        this.gwytdm = gwytdm;
    }

    public String getGwztdm() {
        return gwztdm;
    }

    public void setGwztdm(String gwztdm) {
        this.gwztdm = gwztdm;
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