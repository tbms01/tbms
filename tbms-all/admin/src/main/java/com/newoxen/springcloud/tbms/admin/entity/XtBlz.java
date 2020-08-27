package com.newoxen.springcloud.tbms.admin.entity;

import java.io.Serializable;

/**
 * 表列值(XtBlz)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:11
 */
public class XtBlz implements Serializable {
    private static final long serialVersionUID = -88340302201813356L;
    /**
    * 表名称
    */
    private String bmc;
    /**
    * 列名称
    */
    private String lmc;
    /**
    * 当前值
    */
    private Long dqz;
    /**
    * 取值流水号
    */
    private Long qzlsh;
    /**
    * 地区编码
    */
    private String dqbm;
    /**
    * 创建人编号
    */
    private String cjrbh;
    /**
    * 创建时间
    */
    private Long cjsj;
    /**
    * 操作人编号
    */
    private String czrbh;
    /**
    * 操作时间
    */
    private Long czsj;


    public String getBmc() {
        return bmc;
    }

    public void setBmc(String bmc) {
        this.bmc = bmc;
    }

    public String getLmc() {
        return lmc;
    }

    public void setLmc(String lmc) {
        this.lmc = lmc;
    }

    public Long getDqz() {
        return dqz;
    }

    public void setDqz(Long dqz) {
        this.dqz = dqz;
    }

    public Long getQzlsh() {
        return qzlsh;
    }

    public void setQzlsh(Long qzlsh) {
        this.qzlsh = qzlsh;
    }

    public String getDqbm() {
        return dqbm;
    }

    public void setDqbm(String dqbm) {
        this.dqbm = dqbm;
    }

    public String getCjrbh() {
        return cjrbh;
    }

    public void setCjrbh(String cjrbh) {
        this.cjrbh = cjrbh;
    }

    public Long getCjsj() {
        return cjsj;
    }

    public void setCjsj(Long cjsj) {
        this.cjsj = cjsj;
    }

    public String getCzrbh() {
        return czrbh;
    }

    public void setCzrbh(String czrbh) {
        this.czrbh = czrbh;
    }

    public Long getCzsj() {
        return czsj;
    }

    public void setCzsj(Long czsj) {
        this.czsj = czsj;
    }

}