package com.newoxen.springcloud.tbms.admin.entity;

import java.util.List;

/**
 * 用户权限信息封装类
 *
 * 用于封装用户授权返回：用户-岗位-角色-功能权限
 *
 * @author gaowei
 */

public class UserPermissionInfo {

    public String getM_userId() {
        return m_userId;
    }

    public void setM_userId(String m_userId) {
        this.m_userId = m_userId;
    }

    public String getM_userName() {
        return m_userName;
    }

    public void setM_userName(String m_userName) {
        this.m_userName = m_userName;
    }

    public XtGwxx getM_positionInfo() {
        return m_positionInfo;
    }

    public void setM_positionInfo(XtGwxx m_positionInfo) {
        this.m_positionInfo = m_positionInfo;
    }

    public List<XtJsxx> getM_roleList() {
        return m_roleList;
    }

    public void setM_roleList(List<XtJsxx> m_roleList) {
        this.m_roleList = m_roleList;
    }

    public List<XtGnxx> getM_accessFuncList() {
        return m_accessFuncList;
    }

    public void setM_accessFuncList(List<XtGnxx> m_accessFuncList) {
        this.m_accessFuncList = m_accessFuncList;
    }

    private String m_userId;        //用户信息
    private String m_userName;      //登录账号

    private XtGwxx m_positionInfo;  //岗位信息
    private List<XtJsxx> m_roleList; //角色列表
    private List<XtGnxx> m_accessFuncList; //功能权限


}
