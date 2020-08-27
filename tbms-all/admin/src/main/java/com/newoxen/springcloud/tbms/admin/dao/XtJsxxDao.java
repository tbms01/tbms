package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtJsxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色信息(XtJsxx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface XtJsxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jsbh 主键
     * @return 实例对象
     */
    XtJsxx queryById(String jsbh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtJsxx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryCount(@Param("findtext") String findtext);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtJsxx 实例对象
     * @return 对象列表
     */
    List<XtJsxx> queryAll(XtJsxx xtJsxx);

    /**
     * 新增数据
     *
     * @param xtJsxx 实例对象
     * @return 影响行数
     */
    int insert(XtJsxx xtJsxx);

    /**
     * 修改数据
     *
     * @param xtJsxx 实例对象
     * @return 影响行数
     */
    int update(XtJsxx xtJsxx);

    /**
     * 通过主键删除数据
     *
     * @param jsbh 主键
     * @return 影响行数
     */
    int deleteById(String jsbh);

}