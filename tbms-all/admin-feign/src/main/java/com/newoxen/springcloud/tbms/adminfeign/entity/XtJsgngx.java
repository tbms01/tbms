package com.newoxen.springcloud.tbms.adminfeign.entity;

import java.io.Serializable;

/**
 * 角色功能关系(XtJsgngx)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public class XtJsgngx implements Serializable {
    private static final long serialVersionUID = 594037193188950680L;
    /**
    * 角色编号
    */
    private String jsbh;
    /**
    * 功能编号
    */
    private String gnbh;
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


    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh;
    }

    public String getGnbh() {
        return gnbh;
    }

    public void setGnbh(String gnbh) {
        this.gnbh = gnbh;
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