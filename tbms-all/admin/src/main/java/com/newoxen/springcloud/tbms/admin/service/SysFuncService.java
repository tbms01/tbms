package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.*;
import java.util.List;

/**
 * 功能信息（更新）(XtGnxx)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface SysFuncService {

    /**
     * 通过ID查询单条数据
     *
     * @param appid 主键
     * @return 实例对象
     */
    XtGnxx queryFuncById(String appid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtGnxx> queryAllFuncByPage(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xtGnxx 实例对象
     * @return 实例对象
     */
    XtGnxx insertFunc(XtGnxx xtGnxx);

    /**
     * 修改数据
     *
     * @param xtGnxx 实例对象
     * @return 实例对象
     */
    XtGnxx updateFunc(XtGnxx xtGnxx);

    /**
     * 通过主键删除数据
     *
     * @param appid 主键
     * @return 是否成功
     */
    boolean deleteFuncById(String appid);

}