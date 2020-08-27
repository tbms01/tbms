package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtCzjl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 操作记录（更新）(XtCzjl)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */

@Mapper
public interface XtCzjlDao {

    /**
     * 通过ID查询单条数据
     *
     * @param czlsh 主键
     * @return 实例对象
     */
    XtCzjl queryById(Long czlsh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtCzjl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtCzjl 实例对象
     * @return 对象列表
     */
    List<XtCzjl> queryAll(XtCzjl xtCzjl);

    /**
     * 新增数据
     *
     * @param xtCzjl 实例对象
     * @return 影响行数
     */
    int insert(XtCzjl xtCzjl);

    /**
     * 修改数据
     *
     * @param xtCzjl 实例对象
     * @return 影响行数
     */
    int update(XtCzjl xtCzjl);

    /**
     * 通过主键删除数据
     *
     * @param czlsh 主键
     * @return 影响行数
     */
    int deleteById(Long czlsh);

}