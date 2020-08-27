package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtBlz;
import java.util.List;

/**
 * 表列值(XtBlz)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:15
 */
public interface XtBlzDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bmc 主键
     * @return 实例对象
     */
    XtBlz queryById(String bmc);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtBlz> queryAllByLimit(int offset, int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtBlz 实例对象
     * @return 对象列表
     */
    List<XtBlz> queryAll(XtBlz xtBlz);

    /**
     * 新增数据
     *
     * @param xtBlz 实例对象
     * @return 影响行数
     */
    int insert(XtBlz xtBlz);

    /**
     * 修改数据
     *
     * @param xtBlz 实例对象
     * @return 影响行数
     */
    int update(XtBlz xtBlz);

    /**
     * 通过主键删除数据
     *
     * @param bmc 主键
     * @return 影响行数
     */
    int deleteById(String bmc);

}