package com.newoxen.springcloud.tbms.admin.entity;

import java.io.Serializable;

/**
 * 操作记录（更新）(XtCzjl)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public class XtCzjl implements Serializable {
    private static final long serialVersionUID = -16471478250760020L;
    /**
    * 操作流水号
    */
    private Long czlsh;
    /**
    * 会话ID
    */
    private String hhid;
    /**
    * 操作员编号
    */
    private String czybh;
    /**
    * 功能编号
    */
    private String gnbh;
    /**
    * 功能链接地址
    */
    private String gnljdz;
    /**
    * 链接地址附加参数
    */
    private String ljdzfjcs;
    /**
    * 操作开始时间
    */
    private Long czkssj;
    /**
    * 操作结束时间
    */
    private Long czjssj;
    /**
    * 操作结果代码（成功、失败）
    */
    private String czjgdm;
    /**
    * 结果原因描述（存储失败原因信息）
    */
    private String jgyyms;
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
    /**
    * 操作动作【新增】
    */
    private String czdz;


    public Long getCzlsh() {
        return czlsh;
    }

    public void setCzlsh(Long czlsh) {
        this.czlsh = czlsh;
    }

    public String getHhid() {
        return hhid;
    }

    public void setHhid(String hhid) {
        this.hhid = hhid;
    }

    public String getCzybh() {
        return czybh;
    }

    public void setCzybh(String czybh) {
        this.czybh = czybh;
    }

    public String getGnbh() {
        return gnbh;
    }

    public void setGnbh(String gnbh) {
        this.gnbh = gnbh;
    }

    public String getGnljdz() {
        return gnljdz;
    }

    public void setGnljdz(String gnljdz) {
        this.gnljdz = gnljdz;
    }

    public String getLjdzfjcs() {
        return ljdzfjcs;
    }

    public void setLjdzfjcs(String ljdzfjcs) {
        this.ljdzfjcs = ljdzfjcs;
    }

    public Long getCzkssj() {
        return czkssj;
    }

    public void setCzkssj(Long czkssj) {
        this.czkssj = czkssj;
    }

    public Long getCzjssj() {
        return czjssj;
    }

    public void setCzjssj(Long czjssj) {
        this.czjssj = czjssj;
    }

    public String getCzjgdm() {
        return czjgdm;
    }

    public void setCzjgdm(String czjgdm) {
        this.czjgdm = czjgdm;
    }

    public String getJgyyms() {
        return jgyyms;
    }

    public void setJgyyms(String jgyyms) {
        this.jgyyms = jgyyms;
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

    public String getCzdz() {
        return czdz;
    }

    public void setCzdz(String czdz) {
        this.czdz = czdz;
    }

}