package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtGwxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色信息(XtGwxx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface XtGwxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param gwbh 主键
     * @return 实例对象
     */
    XtGwxx queryById(String gwbh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtGwxx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryCount(@Param("findtext") String findtext);

    /**
     * 查询所有岗位
     * @return
     */
    List<XtGwxx> queryAllId();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtGwxx 实例对象
     * @return 对象列表
     */
    List<XtGwxx> queryAll(XtGwxx xtGwxx);

    /**
     * 新增数据
     *
     * @param xtGwxx 实例对象
     * @return 影响行数
     */
    int insert(XtGwxx xtGwxx);

    /**
     * 修改数据
     *
     * @param xtGwxx 实例对象
     * @return 影响行数
     */
    int update(XtGwxx xtGwxx);

    /**
     * 通过主键删除数据
     *
     * @param gwbh 主键
     * @return 影响行数
     */
    int deleteById(String gwbh);

}