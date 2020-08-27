package com.newoxen.springcloud.tbms.admin.entity;

import java.io.Serializable;

/**
 * 操作员信息(XtCzyxx)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public class XtCzyxx implements Serializable {
    private static final long serialVersionUID = -30706223132551428L;
    /**
    * 操作员编号
    */
    private String czybh;


    /**
    * 组织编码
    */
    private String zzbm;
    /**
    * 岗位编号
    */
    private String gwbh;


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

    /**
     * 组织编码
     */
    private String zzmc;
    /**
     * 岗位编号
     */
    private String gwmc;

    /**
    * 登录账号
    */
    private String dlzh;
    /**
    * 登录密码
    */
    private String dlmm;
    /**
    * 操作员工号
    */
    private String czygh;
    /**
    * 操作员名称
    */
    private String czymc;
    /**
    * 办公电话号码
    */
    private String bgdhhm;
    /**
    * 手机号码
    */
    private String sjhm;
    /**
    * 性别代码
    */
    private String xbdm;
    /**
    * 出生日期
    */
    private String csrq;
    /**
    * 职称
    */
    private String zc;
    /**
    * 职务
    */
    private String zw;
    /**
    * 单位
    */
    private String dw;
    /**
    * 登录密码已错误次数
    */
    private Integer dlmmycwcs;
    /**
    * 登录密码最大错误次数
    */
    private Integer dlmmzdcwcs;
    /**
    * 违章扣分
    */
    private Integer wzkf;
    /**
    * 操作员状态代码（正常、停用、锁定等）
    */
    private String czyztdm;
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
    /**
    * 4A邮箱
    */
    private String email;
    /**
    * 用户头像
    */
    private Object avatar;


    public String getCzybh() {
        return czybh;
    }

    public void setCzybh(String czybh) {
        this.czybh = czybh;
    }

    public String getZzbm() {
        return zzbm;
    }

    public void setZzbm(String zzbm) {
        this.zzbm = zzbm;
    }

    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh;
    }

    public String getDlzh() {
        return dlzh;
    }

    public void setDlzh(String dlzh) {
        this.dlzh = dlzh;
    }

    public String getDlmm() {
        return dlmm;
    }

    public void setDlmm(String dlmm) {
        this.dlmm = dlmm;
    }

    public String getCzygh() {
        return czygh;
    }

    public void setCzygh(String czygh) {
        this.czygh = czygh;
    }

    public String getCzymc() {
        return czymc;
    }

    public void setCzymc(String czymc) {
        this.czymc = czymc;
    }

    public String getBgdhhm() {
        return bgdhhm;
    }

    public void setBgdhhm(String bgdhhm) {
        this.bgdhhm = bgdhhm;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Integer getDlmmycwcs() {
        return dlmmycwcs;
    }

    public void setDlmmycwcs(Integer dlmmycwcs) {
        this.dlmmycwcs = dlmmycwcs;
    }

    public Integer getDlmmzdcwcs() {
        return dlmmzdcwcs;
    }

    public void setDlmmzdcwcs(Integer dlmmzdcwcs) {
        this.dlmmzdcwcs = dlmmzdcwcs;
    }

    public Integer getWzkf() {
        return wzkf;
    }

    public void setWzkf(Integer wzkf) {
        this.wzkf = wzkf;
    }

    public String getCzyztdm() {
        return czyztdm;
    }

    public void setCzyztdm(String czyztdm) {
        this.czyztdm = czyztdm;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

}