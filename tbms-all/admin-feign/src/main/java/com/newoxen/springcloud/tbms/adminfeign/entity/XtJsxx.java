package com.newoxen.springcloud.tbms.adminfeign.entity;

import java.io.Serializable;

/**
 * 角色信息(XtJsxx)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public class XtJsxx implements Serializable {
    private static final long serialVersionUID = 962048191469643105L;
    /**
    * 角色编号
    */
    private String jsbh;
    /**
    * 角色标志（是，否）
    */
    private String jsbz;
    /**
    * 上级角色编号
    */
    private String sjjsbh;
    /**
    * 所属系统
    */
    private String ssxt;
    /**
    * 角色名称
    */
    private String jsmc;
    /**
    * 角色描述
    */
    private String jsms;
    /**
    * 角色用途代码（1：供电所，2：服务中心，3：供电局，4：县公司）
    */
    private String jsytdm;
    /**
    * 状态变更时间
    */
    private String ztbgsj;
    /**
    * 创建人编号
    */
    private String cjrbh;
    /**
    * 角色状态代码（正常、停用等）
    */
    private String jsztdm;
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


    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh;
    }

    public String getJsbz() {
        return jsbz;
    }

    public void setJsbz(String jsbz) {
        this.jsbz = jsbz;
    }

    public String getSjjsbh() {
        return sjjsbh;
    }

    public void setSjjsbh(String sjjsbh) {
        this.sjjsbh = sjjsbh;
    }

    public String getSsxt() {
        return ssxt;
    }

    public void setSsxt(String ssxt) {
        this.ssxt = ssxt;
    }

    public String getJsmc() {
        return jsmc;
    }

    public void setJsmc(String jsmc) {
        this.jsmc = jsmc;
    }

    public String getJsms() {
        return jsms;
    }

    public void setJsms(String jsms) {
        this.jsms = jsms;
    }

    public String getJsytdm() {
        return jsytdm;
    }

    public void setJsytdm(String jsytdm) {
        this.jsytdm = jsytdm;
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

    public String getJsztdm() {
        return jsztdm;
    }

    public void setJsztdm(String jsztdm) {
        this.jsztdm = jsztdm;
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