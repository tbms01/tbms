package com.newoxen.springcloud.tbms.admin.entity;

import java.io.Serializable;

/**
 * 功能信息（更新）(XtGnxx)实体类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public class XtGnxx implements Serializable {
    private static final long serialVersionUID = -17258412148153464L;
    /**
    * 应用ID【新增】
    */
    private String appid;
    /**
    * 功能编号
    */
    private String gnbh;
    /**
    * 上级功能编号(操作的上级是功能,功能的上级是模块,模块的上级也可以是模块)
    */
    private String sjgnbh;
    /**
    * 功能名称
    */
    private String gnmc;
    /**
    * 所属系统
    */
    private String ssxt;
    /**
    * 功能描述
    */
    private String gnms;
    /**
    * 元素ID(针对操作类界面元素是否显示的元素ID，比如按钮等)
    */
    private String ysid;
    /**
    * 功能链接地址
    */
    private String gnljdz;
    /**
    * 链接地址附加参数
    */
    private String ljdzfjcs;
    /**
    * 功能链接方式代码（内部链接、外部链接）
    */
    private String gnljfsdm;
    /**
    * 功能类型代码(0_模块,1_功能,2_操作)
    */
    private String gnlxdm;
    /**
    * 功能用途代码(0_系统管理,1_业务操作)
    */
    private String gnytdm;
    /**
    * 功能图标类名称(存储功能图标CSS类名称)
    */
    private String gntblmc;
    /**
    * 功能图标链接地址(存储功能图标文件名和相对路径)
    */
    private String gntbljdz;
    /**
    * 功能版本号
    */
    private String gnbbh;
    /**
    * 顶级模块顺序号
    */
    private Integer djmksxh;
    /**
    * 模块顺序号
    */
    private Integer mksxh;
    /**
    * 功能顺序号
    */
    private Integer gnsxh;
    /**
    * 操作顺序号
    */
    private Integer czsxh;
    /**
    * 隐藏标志（是、否）
    */
    private String ycbz;
    /**
    * 功能状态代码（正常、停用等）
    */
    private String gnztdm;
    /**
    * 状态变更时间
    */
    private Long ztbgsj;
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


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getGnbh() {
        return gnbh;
    }

    public void setGnbh(String gnbh) {
        this.gnbh = gnbh;
    }

    public String getSjgnbh() {
        return sjgnbh;
    }

    public void setSjgnbh(String sjgnbh) {
        this.sjgnbh = sjgnbh;
    }

    public String getGnmc() {
        return gnmc;
    }

    public void setGnmc(String gnmc) {
        this.gnmc = gnmc;
    }

    public String getSsxt() {
        return ssxt;
    }

    public void setSsxt(String ssxt) {
        this.ssxt = ssxt;
    }

    public String getGnms() {
        return gnms;
    }

    public void setGnms(String gnms) {
        this.gnms = gnms;
    }

    public String getYsid() {
        return ysid;
    }

    public void setYsid(String ysid) {
        this.ysid = ysid;
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

    public String getGnljfsdm() {
        return gnljfsdm;
    }

    public void setGnljfsdm(String gnljfsdm) {
        this.gnljfsdm = gnljfsdm;
    }

    public String getGnlxdm() {
        return gnlxdm;
    }

    public void setGnlxdm(String gnlxdm) {
        this.gnlxdm = gnlxdm;
    }

    public String getGnytdm() {
        return gnytdm;
    }

    public void setGnytdm(String gnytdm) {
        this.gnytdm = gnytdm;
    }

    public String getGntblmc() {
        return gntblmc;
    }

    public void setGntblmc(String gntblmc) {
        this.gntblmc = gntblmc;
    }

    public String getGntbljdz() {
        return gntbljdz;
    }

    public void setGntbljdz(String gntbljdz) {
        this.gntbljdz = gntbljdz;
    }

    public String getGnbbh() {
        return gnbbh;
    }

    public void setGnbbh(String gnbbh) {
        this.gnbbh = gnbbh;
    }

    public Integer getDjmksxh() {
        return djmksxh;
    }

    public void setDjmksxh(Integer djmksxh) {
        this.djmksxh = djmksxh;
    }

    public Integer getMksxh() {
        return mksxh;
    }

    public void setMksxh(Integer mksxh) {
        this.mksxh = mksxh;
    }

    public Integer getGnsxh() {
        return gnsxh;
    }

    public void setGnsxh(Integer gnsxh) {
        this.gnsxh = gnsxh;
    }

    public Integer getCzsxh() {
        return czsxh;
    }

    public void setCzsxh(Integer czsxh) {
        this.czsxh = czsxh;
    }

    public String getYcbz() {
        return ycbz;
    }

    public void setYcbz(String ycbz) {
        this.ycbz = ycbz;
    }

    public String getGnztdm() {
        return gnztdm;
    }

    public void setGnztdm(String gnztdm) {
        this.gnztdm = gnztdm;
    }

    public Long getZtbgsj() {
        return ztbgsj;
    }

    public void setZtbgsj(Long ztbgsj) {
        this.ztbgsj = ztbgsj;
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