package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtSjqx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 数据权限(XtSjqx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface XtSjqxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param appid 主键
     * @return 实例对象
     */
    XtSjqx queryById(String appid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtSjqx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtSjqx 实例对象
     * @return 对象列表
     */
    List<XtSjqx> queryAll(XtSjqx xtSjqx);

    /**
     * 新增数据
     *
     * @param xtSjqx 实例对象
     * @return 影响行数
     */
    int insert(XtSjqx xtSjqx);

    /**
     * 修改数据
     *
     * @param xtSjqx 实例对象
     * @return 影响行数
     */
    int update(XtSjqx xtSjqx);

    /**
     * 通过主键删除数据
     *
     * @param appid 主键
     * @return 影响行数
     */
    int deleteById(String appid);

}