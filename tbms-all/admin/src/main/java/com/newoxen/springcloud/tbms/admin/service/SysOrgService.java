package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.*;

import java.util.List;

/**
 * 组织信息(XtZzxx)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 11:29:44
 */
public interface SysOrgService {

    /**
     * 通过ID查询单条数据
     *
     * @param zzbm 主键
     * @return 实例对象
     */
    XtZzxx queryById(String zzbm);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtZzxx> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有组织
     * @return
     */
    List<XtZzxx> queryAll();

    /**
     * 新增数据
     *
     * @param xtZzxx 实例对象
     * @return 实例对象
     */
    XtZzxx insert(XtZzxx xtZzxx);

    /**
     * 修改数据
     *
     * @param xtZzxx 实例对象
     * @return 实例对象
     */
    XtZzxx update(XtZzxx xtZzxx);

    /**
     * 通过主键删除数据
     *
     * @param zzbm 主键
     * @return 是否成功
     */
    boolean deleteById(String zzbm);

    /**
     * 根据关键字查询多条数据
     *
     * @param findtext 关键字
     * @return 对象列表
     */
    List<XtZzxx> queryAllUserByFilter(String findtext, int offset, int limit);

    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryAllByFilterCount(String findtext, int offset, int limit);

    /**
     * 根据父级过滤查询
     *
     * @param sjzzbm 关键字
     * @return 对象列表
     */
    List<LayUITree> queryAllByFather(String sjzzbm);

    /**
     * 根据父级过滤查询
     *
     * @param sjzzbm 关键字
     * @return 对象列表
     */
    List<XtZzxxExtend> queryAllByFatherPager(String sjzzbm, int offset, int limit);

    /**
     * 根据父级过滤查询-汇总行数
     * @param sjzzbm
     * @return
     */
    Integer queryAllByFatherPagerCount(String sjzzbm, int offset, int limit);


    /**
     * 保存组织信息
     *
     * @param xZzxx 实例对象
     * @return u
     */
    String saveOrg(XtZzxx xZzxx);
}