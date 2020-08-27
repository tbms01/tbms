package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 功能信息（更新）(XtGnxx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface XtGnxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param appid 主键
     * @return 实例对象
     */
    XtGnxx queryById(String appid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtGnxx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtGnxx 实例对象
     * @return 对象列表
     */
    List<XtGnxx> queryAll(XtGnxx xtGnxx);

    /**
     * 新增数据
     *
     * @param xtGnxx 实例对象
     * @return 影响行数
     */
    int insert(XtGnxx xtGnxx);

    /**
     * 修改数据
     *
     * @param xtGnxx 实例对象
     * @return 影响行数
     */
    int update(XtGnxx xtGnxx);

    /**
     * 通过主键删除数据
     *
     * @param appid 主键
     * @return 影响行数
     */
    int deleteById(String appid);

}