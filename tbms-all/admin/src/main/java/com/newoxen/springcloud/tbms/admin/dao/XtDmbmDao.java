package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtDmbm;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 存放代码对应的编码内容(XtDmbm)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public interface XtDmbmDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dmbmbs 主键
     * @return 实例对象
     */
    XtDmbm queryById(String dmbmbs);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtDmbm> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtDmbm 实例对象
     * @return 对象列表
     */
    List<XtDmbm> queryAll(XtDmbm xtDmbm);

    /**
     * 新增数据
     *
     * @param xtDmbm 实例对象
     * @return 影响行数
     */
    int insert(XtDmbm xtDmbm);

    /**
     * 修改数据
     *
     * @param xtDmbm 实例对象
     * @return 影响行数
     */
    int update(XtDmbm xtDmbm);

    /**
     * 通过主键删除数据
     *
     * @param dmbmbs 主键
     * @return 影响行数
     */
    int deleteById(String dmbmbs);

}