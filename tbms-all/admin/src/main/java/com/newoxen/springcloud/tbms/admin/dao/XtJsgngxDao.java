package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtJsgngx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色功能关系(XtJsgngx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface XtJsgngxDao {

    /**
     * 删除角色下功能
     * @param jsbh
     * @return
     */
    int deleteAllByRole(@Param("jsbh")String jsbh);

    /**
     * 删除岗位下权限
     * @param gwbh
     * @return
     */
    int deleteAllByPosition(@Param("gwbh")String gwbh);


    /**
     * 通过ID查询单条数据
     *
     * @param jsbh 主键
     * @return 实例对象
     */
    XtJsgngx queryById(String jsbh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtJsgngx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtJsgngx 实例对象
     * @return 对象列表
     */
    List<XtJsgngx> queryAll(XtJsgngx xtJsgngx);

    /**
     * 新增数据
     *
     * @param xtJsgngx 实例对象
     * @return 影响行数
     */
    int insert(XtJsgngx xtJsgngx);

    
    /**
     * 修改数据
     *
     * @param xtJsgngx 实例对象
     * @return 影响行数
     */
    int update(XtJsgngx xtJsgngx);

    /**
     * 通过主键删除数据
     *
     * @param jsbh 主键
     * @param gnbh 主键
     * @return 影响行数
     */
    int deleteById(String jsbh, String gnbh);

    /**
     * 移除岗位和角色的关系
     * @param gwbh
     * @param jsbh
     * @return
     */
    boolean deletePositionRole(String gwbh, String jsbh);

    int add(List<XtJsgngx> list);
}