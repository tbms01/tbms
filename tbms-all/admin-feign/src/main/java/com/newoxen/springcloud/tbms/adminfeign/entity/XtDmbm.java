package com.newoxen.springcloud.tbms.adminfeign.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 存放代码对应的编码内容(XtDmbm)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public class XtDmbm implements Serializable {
    private static final long serialVersionUID = 576623008299221109L;
    /**
    * 代码编码的唯一标识
    */
    private String dmbmbs;
    /**
    * 代码分类的唯一标识
    */
    private String dmflbs;
    /**
    * 上级代码编码标识，用来描述树形代码对应的上下级关系
    */
    private String sjdmbmbs;
    /**
    * （冗余字段），方便数据查询
    */
    private String dmfl;
    /**
    * 代码编码的内码，用来唯一标识代码编码（以代码分类为单位）
    */
    private String dmbmnm;
    /**
    * 代码分类的编码内容，如紧急程度代码中：\\r\\n                代码编码         代码编码名称\\r\\n                1                特急\\r\\n                2                紧急\\r\\n                3                一般
    */
    private String dmbm;
    /**
    * 代码分类的编码名称，如紧急程度代码中：\\r\\n                代码编码         代码编码名称\\r\\n                1                特急\\r\\n                2                紧急\\r\\n                3                一般
    */
    private String dmbmmc;
    /**
    * 用于同一代码分类的排序
    */
    private Double xssx;
    /**
    * 可选标志，用于代码是否可选 如 0 否  1 是
    */
    private String kxbz;
    /**
    * 可选,用来根据应用场景筛选同一代码分类对应的编码内容，如电压等级的内容如下：\\\\r\\\\n              代码编码   代码编码名称   应用场景1        应用场景2\\\\r\\\\n              01         750kV          变电站电压等级\\\\r\\\\n              02         500kV          变电站电压等级\\\\r\\\\n              03         220kV          变电站电压等级  \\\\r\\\\n              04         110kV          变电站电压等级  高压用电\\\\r\\\\n              05         35kV           变电站电压等级  高压用电\\\\r\\\\n              06         20kV                           高压用电\\\\r\\\\n              07         10kV                           高压用电 \\\\r\\\\n              08         380kV                          低压用电\\\\r\\\\n              09         220kV                          低压用电 \\\\r\\\\n            
    */
    private String yycj1;
    /**
    * 同应用场景1
    */
    private String yycj2;
    /**
    * 同应用场景1
    */
    private String yycj3;
    /**
    * 同应用场景1
    */
    private String yycj4;
    /**
    * 同应用场景1
    */
    private String yycj5;
    /**
    * 可选，用来建立代码与代码分类之间的对照关系
    */
    private String dzgx1;
    /**
    * 可选，用来建立代码与代码分类之间的对照关系
    */
    private String dzgx2;
    /**
    * 可选，用来建立代码与代码分类之间的对照关系
    */
    private String dzgx3;
    /**
    * 数据创建时间
    */
    private Date cjsj;
    /**
    * 数据最近一次变更时间
    */
    private Date czsj;


    public String getDmbmbs() {
        return dmbmbs;
    }

    public void setDmbmbs(String dmbmbs) {
        this.dmbmbs = dmbmbs;
    }

    public String getDmflbs() {
        return dmflbs;
    }

    public void setDmflbs(String dmflbs) {
        this.dmflbs = dmflbs;
    }

    public String getSjdmbmbs() {
        return sjdmbmbs;
    }

    public void setSjdmbmbs(String sjdmbmbs) {
        this.sjdmbmbs = sjdmbmbs;
    }

    public String getDmfl() {
        return dmfl;
    }

    public void setDmfl(String dmfl) {
        this.dmfl = dmfl;
    }

    public String getDmbmnm() {
        return dmbmnm;
    }

    public void setDmbmnm(String dmbmnm) {
        this.dmbmnm = dmbmnm;
    }

    public String getDmbm() {
        return dmbm;
    }

    public void setDmbm(String dmbm) {
        this.dmbm = dmbm;
    }

    public String getDmbmmc() {
        return dmbmmc;
    }

    public void setDmbmmc(String dmbmmc) {
        this.dmbmmc = dmbmmc;
    }

    public Double getXssx() {
        return xssx;
    }

    public void setXssx(Double xssx) {
        this.xssx = xssx;
    }

    public String getKxbz() {
        return kxbz;
    }

    public void setKxbz(String kxbz) {
        this.kxbz = kxbz;
    }

    public String getYycj1() {
        return yycj1;
    }

    public void setYycj1(String yycj1) {
        this.yycj1 = yycj1;
    }

    public String getYycj2() {
        return yycj2;
    }

    public void setYycj2(String yycj2) {
        this.yycj2 = yycj2;
    }

    public String getYycj3() {
        return yycj3;
    }

    public void setYycj3(String yycj3) {
        this.yycj3 = yycj3;
    }

    public String getYycj4() {
        return yycj4;
    }

    public void setYycj4(String yycj4) {
        this.yycj4 = yycj4;
    }

    public String getYycj5() {
        return yycj5;
    }

    public void setYycj5(String yycj5) {
        this.yycj5 = yycj5;
    }

    public String getDzgx1() {
        return dzgx1;
    }

    public void setDzgx1(String dzgx1) {
        this.dzgx1 = dzgx1;
    }

    public String getDzgx2() {
        return dzgx2;
    }

    public void setDzgx2(String dzgx2) {
        this.dzgx2 = dzgx2;
    }

    public String getDzgx3() {
        return dzgx3;
    }

    public void setDzgx3(String dzgx3) {
        this.dzgx3 = dzgx3;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }

}