package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import com.newoxen.springcloud.tbms.admin.entity.XtGwjsgx;
import com.newoxen.springcloud.tbms.admin.entity.XtJsxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 岗位角色关系(XtGwjsgx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
public interface XtGwjsgxDao {

    /**
     * 查询用户具备权限应用
     * @param gwbh
     * @return
     */
    List<XtGnxx> queryApplication(@Param("gwbh")String gwbh);



    /**
     * 查询用户具备权限功能菜单所有但钱下级
     * @param sjgnbh
     * @param gwbh
     * @return
     */
    List<XtGnxx> queryFuncAllChildren(@Param("sjgnbh")String sjgnbh, @Param("gwbh")String gwbh);


    /**
     * 根据用户岗位查询功能权限
     * @param gwbh
     * @return
     */
    List<XtGnxx> queryAllFuncsByPosition(@Param("gwbh")String gwbh,@Param("jsbh")String jsbh);

    /**
     * 查询某个角色不包含的功能权限
     * @param jsbh
     * @return
     */
    List<XtGnxx> queryAllFuncsByRoleNo(@Param("jsbh")String jsbh);

    /**
     * 根据用户岗位查询角色
     * @param gwbh
     * @return
     */
    List<XtJsxx> queryAllRolesByPosition(@Param("gwbh")String gwbh);


    /**
     * 查询不属于该用户岗位的角色
     * @param gwbh
     * @return
     */
    List<XtJsxx> queryAllRolesByPositionNo(@Param("gwbh")String gwbh);

    /**
     * 通过ID查询单条数据
     *
     * @param gwbh 主键
     * @return 实例对象
     */
    XtGwjsgx queryById(String gwbh);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtGwjsgx> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param xtGwjsgx 实例对象
     * @return 对象列表
     */
    List<XtGwjsgx> queryAll(XtGwjsgx xtGwjsgx);

    /**
     * 新增数据
     *
     * @param list 实例对象
     * @return 影响行数
     */
    int insert(List<XtGwjsgx> list);

    /**
     * 修改数据
     *
     * @param xtGwjsgx 实例对象
     * @return 影响行数
     */
    int update(XtGwjsgx xtGwjsgx);

    /**
     * 通过主键删除数据
     *
     * @param gwbh 主键
     * @return 影响行数
     */
    int deleteById(String gwbh);

    /**
     * 移除一条岗位和角色关系
     * @param gwbh
     * @param jsbh
     * @return
     */
    boolean deletePositionRole(String gwbh, String jsbh);
}