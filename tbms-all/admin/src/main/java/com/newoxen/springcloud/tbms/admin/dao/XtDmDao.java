package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.admin.entity.XtDm;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 代码(XtDm)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 11:27:04
 */
public interface XtDmDao {

    /**
     * #根据关键字查询
     *
     * @param findtext 查询关键字
     * @return 对象列表
     */
    List<XtDm> queryAllByFilter(@Param("findtext") String findtext, @Param("offset") int offset, @Param("limit")int limit);


    /**
     * #汇总行数
     * @param findtext
     * @return
     */
    Integer queryAllByFilterCount(@Param("findtext") String findtext);


    /**
     * 通过ID查询单条数据
     *
     * @param dmbh 主键
     * @return 实例对象
     */
    XtDm queryById(String dmbh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtDm> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtDm 实例对象
     * @return 对象列表
     */
    List<XtDm> queryAll(XtDm xtDm);

    /**
     * 新增数据
     *
     * @param xtDm 实例对象
     * @return 影响行数
     */
    int insert(XtDm xtDm);

    /**
     * 修改数据
     *
     * @param xtDm 实例对象
     * @return 影响行数
     */
    int update(XtDm xtDm);

    /**
     * 通过主键删除数据
     *
     * @param dmbh 主键
     * @return 影响行数
     */
    int deleteById(String dmbh);

}