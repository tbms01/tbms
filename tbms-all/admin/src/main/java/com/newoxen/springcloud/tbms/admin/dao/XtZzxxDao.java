package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtGwxx;
import com.newoxen.springcloud.tbms.admin.entity.XtZzxx;
import com.newoxen.springcloud.tbms.admin.entity.XtZzxxExtend;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 组织信息(XtZzxx)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 11:29:44
 */
public interface XtZzxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param zzbm 主键
     * @return 实例对象
     */
    XtZzxx queryById(String zzbm);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtZzxx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询所有组织
     * @return
     */
    List<XtZzxx> queryAllOrg();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtZzxx 实例对象
     * @return 对象列表
     */
    List<XtZzxx> queryAll(XtZzxx xtZzxx);

    /**
     * 新增数据
     *
     * @param xtZzxx 实例对象
     * @return 影响行数
     */
    int insert(XtZzxx xtZzxx);

    /**
     * 修改数据
     *
     * @param xtZzxx 实例对象
     * @return 影响行数
     */
    int update(XtZzxx xtZzxx);

    /**
     * 通过主键删除数据
     *
     * @param zzbm 主键
     * @return 影响行数
     */
    int deleteById(String zzbm);

    /**
     * 根据关键字查询
     *
     * @param findtext 查询关键字
     * @return 对象列表
     */
    List<XtZzxx> queryAllByFilter(@Param("findtext") String findtext, @Param("offset") int offset, @Param("limit")int limit);


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryAllByFilterCount(@Param("findtext") String findtext, @Param("offset") int offset, @Param("limit")int limit);

    /**
     * 根据父级过滤查询
     *
     * @param sjzzbm 父级
     * @return 对象列表
     */
    List<XtZzxxExtend> queryAllByFather(@Param("sjzzbm") String sjzzbm);

    /**
     * 根据父级过滤查询
     *
     * @param sjzzbm 父级
     * @return 对象列表
     */
    List<XtZzxxExtend> queryAllByFatherPager(@Param("sjzzbm") String sjzzbm, @Param("offset") int offset, @Param("limit")int limit);


    /**
     * 根据父级过滤查询-汇总行数
     * @param sjzzbm
     * @return
     */
    Integer queryAllByFatherPagerCount(@Param("sjzzbm") String sjzzbm, @Param("offset") int offset, @Param("limit")int limit);
}