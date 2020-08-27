package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.XtCzjl;
import java.util.List;

/**
 * 操作记录（更新）(XtCzjl)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public interface SysActionLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param czlsh 主键
     * @return 实例对象
     */
    XtCzjl queryActionLogById(Long czlsh);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtCzjl> queryActionLogAllByPage(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xtCzjl 实例对象
     * @return 实例对象
     */
    XtCzjl insertActionLog(XtCzjl xtCzjl);

    /**
     * 修改数据
     *
     * @param xtCzjl 实例对象
     * @return 实例对象
     */
    XtCzjl updateActionLog(XtCzjl xtCzjl);

    /**
     * 通过主键删除数据
     *
     * @param czlsh 主键
     * @return 是否成功
     */
    boolean deleteActionLogById(Long czlsh);

}