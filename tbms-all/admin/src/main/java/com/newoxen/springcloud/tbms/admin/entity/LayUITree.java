package com.newoxen.springcloud.tbms.admin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * layui tree数据源
 */
public class LayUITree implements Serializable {
    /**
     * 名称
     */
    private String title;
    /**
     * id
     */
    private String id;
    /**
     * 子列表
     */
    private List<LayUITree> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String zzbm) {
        this.title = zzbm;
    }

    public String getId() {
        return id;
    }

    public void setId(String zzmc) {
        this.id = zzmc;
    }

    public List<LayUITree> getChildren() {
        return children;
    }

    public void setChildren(List<LayUITree> zzjc) {
        this.children = zzjc;
    }
}
