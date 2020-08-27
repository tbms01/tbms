package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色功能关系(XtJsgngx)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface SysAuthAccessService {


    /**
     * 查询用户具备权限应用
     * @param gwbh
     * @return
     */
    List<XtGnxx> queryApplication(String gwbh);



    /**
     * 查询用户具备权限功能菜单所有但钱下级
     * @param sjgnbh
     * @param gwbh
     * @return
     */
    List<XtGnxx> queryFuncAllChildren(String sjgnbh, String gwbh);


    /**
     * 根据用户查询所有功能权限
     *
     * @param gwbh 岗位编号
     * @return 实例对象
     */
    List<XtGnxx> queryAllFuncsByPosition(String gwbh,String jsbh);




    /* ------------ 角色功能权限 -----------------------------------------------------------------------------------------------* /



    /**
     * 新增数据
     *
     * @param jsbh
     * @param gnbh
     * @return 实例对象
     */
    boolean addRoleFunc(String jsbh, String gnbh);

    /**
     * 新增数据
     *
     * @param jsbh
     * @param listGnbh
     * @return 实例对象
     */
    boolean addFuncRole(String jsbh, List<String> listGnbh, String czybh);

    /**
     * 查询某个角色不包含的功能
     * @param jsbh
     * @return
     */
    List<XtGnxx> queryAllFuncsByPosition( String jsbh);


    /**
     * 通过主键删除数据
     *
     * @param jsbh
     * @param gnbh
     * @return 是否成功
     */
    boolean removeRoleFunc(String jsbh, String gnbh);

    /**
     * 移除角色下全部功能
     * @param jsbh
     * @return
     */
    boolean removeAllRoleFunc(String jsbh);



    /* ------------------ 岗位角色权限 -----------------------------------------------------------------------------------------* /


    /**
     * 根据岗位查询所有角色
     *
     * @param gwbh 主键
     * @return 实例对象
     */
    List<XtJsxx> queryAllRolesByPosition(String gwbh);

    /**
     * 查询不属于该岗位的角色
     *
     * @param gwbh 主键
     * @return 实例对象
     */
    List<XtJsxx> queryAllRolesByPositionNo(String gwbh);




    /**
     * 新增数据
     *
     * @param xtGwjsgx 实例对象
     * @return 实例对象
     */
    XtGwjsgx addPositionRole(XtGwjsgx xtGwjsgx);


    /**
     * 删除某岗位某角色关系
     *
     * @param gwbh 主键
     * @param jsbh 主键
     * @return 是否成功
     */
    boolean removePositionRole(String gwbh, String jsbh);

    /**
     * 删除某岗位全部角色关系
     *
     * @param gwbh 主键
     * @return 是否成功
     */
    boolean removeAllPositionRole(String gwbh);

    /**
     * 新增数据
     *
     * @param listJsbh 实例对象
     * @return 实例对象
     */
    boolean addRolePosition(String gwbh, List<String> listJsbh,String czybh);
}