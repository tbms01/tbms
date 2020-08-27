package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.*;
import java.util.List;

/**
 * 角色信息(XtJsxx)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface SysRoleService {




    /**
     * 通过ID查询单条数据
     *
     * @param jsbh 主键
     * @return 实例对象
     */
    XtJsxx queryRoleById(String jsbh);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtJsxx> queryAllRoleByPage( int offset, int limit);


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryCount(String findtext);

    /**
     * 新增数据
     *
     * @param xtJsxx 实例对象
     * @return 实例对象
     */
    XtJsxx insertRole(XtJsxx xtJsxx);

    /**
     * 修改数据
     *
     * @param xtJsxx 实例对象
     * @return 实例对象
     */
    XtJsxx updateRole(XtJsxx xtJsxx);

    /**
     * 通过主键删除数据
     *
     * @param jsbh 主键
     * @return 是否成功
     */
    boolean deleteRoleById(String jsbh);




}