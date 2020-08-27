package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtFjxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 附件信息(XtFjxx)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 11:31:17
 */
public interface XtFjxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fjbh 主键
     * @return 实例对象
     */
    XtFjxx queryById(String fjbh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtFjxx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtFjxx 实例对象
     * @return 对象列表
     */
    List<XtFjxx> queryAll(XtFjxx xtFjxx);

    /**
     * 新增数据
     *
     * @param xtFjxx 实例对象
     * @return 影响行数
     */
    int insert(XtFjxx xtFjxx);

    /**
     * 修改数据
     *
     * @param xtFjxx 实例对象
     * @return 影响行数
     */
    int update(XtFjxx xtFjxx);

    /**
     * 通过主键删除数据
     *
     * @param fjbh 主键
     * @return 影响行数
     */
    int deleteById(String fjbh);

}