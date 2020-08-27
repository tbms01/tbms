package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.*;
import java.util.List;

/**
 * 数据权限(XtSjqx)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface SysDataAccessService {

    /**
     * 通过ID查询单条数据
     *
     * @param appid 主键
     * @return 实例对象
     */
    XtSjqx queryDataAccessById(String appid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtSjqx> queryAllDataAccessByPage(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xtSjqx 实例对象
     * @return 实例对象
     */
    XtSjqx insertDataAccess(XtSjqx xtSjqx);

    /**
     * 修改数据
     *
     * @param xtSjqx 实例对象
     * @return 实例对象
     */
    XtSjqx updateDataAccess(XtSjqx xtSjqx);

    /**
     * 通过主键删除数据
     *
     * @param appid 主键
     * @return 是否成功
     */
    boolean deleteDataAccessById(String appid);

}