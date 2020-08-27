package com.newoxen.springcloud.tbms.admin.entity;

import java.io.Serializable;

/**
 * 数据权限(XtSjqx)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public class XtSjqx implements Serializable {
    private static final long serialVersionUID = -22107144906304958L;
    /**
    * meta_app应用ID
    */
    private String appid;
    /**
    * 数据集名称
    */
    private String dataset;
    /**
    * 机构编号
    */
    private String jgbh;
    /**
    * 岗位编号
    */
    private String gwbh;
    /**
    * 角色编号
    */
    private String jsbh;
    /**
    * 操作员编号
    */
    private String czybh;
    /**
    * 数据过滤条件
    */
    private String gltj;


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getJgbh() {
        return jgbh;
    }

    public void setJgbh(String jgbh) {
        this.jgbh = jgbh;
    }

    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh;
    }

    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh;
    }

    public String getCzybh() {
        return czybh;
    }

    public void setCzybh(String czybh) {
        this.czybh = czybh;
    }

    public String getGltj() {
        return gltj;
    }

    public void setGltj(String gltj) {
        this.gltj = gltj;
    }

}