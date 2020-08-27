package com.newoxen.springcloud.tbms.adminfeign.entity;

import java.io.Serializable;

/**
 * 组织信息(XtZzxx)实体类
 *
 * @author makejava
 * @since 2020-06-01 11:29:42
 */
public class XtZzxxExtend extends XtZzxx implements Serializable{

    /**
    * 单位标志（0、单位 1、部门）
    */
    private String dwbzmc;
    /**
    * 申购结算标志（是、否，申购结算标志为是，才可以将用电客户挂在这个组织编码下）
    */
    private String sgjsbzmc;

    /**
    * 组织状态代码（正常、停用、锁定等）
    */
    private String zzztdmmc;

    public String getDwbzmc() {
        return dwbzmc;
    }

    public void setDwbzmc(String dwbzmc) {
        this.dwbzmc = dwbzmc;
    }

    public String getSgjsbzmc() {
        return sgjsbzmc;
    }

    public void setSgjsbzmc(String sgjsbzmc) {
        this.sgjsbzmc = sgjsbzmc;
    }

    public String getZzztdmmc() {
        return zzztdmmc;
    }

    public void setZzztdmmc(String zzztdmmc) {
        this.zzztdmmc = zzztdmmc;
    }
}