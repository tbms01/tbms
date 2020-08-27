package com.newoxen.springcloud.tbms.admin.dao;

import com.newoxen.springcloud.tbms.admin.entity.XtCzyxx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 操作员信息(XtCzyxx)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public interface XtCzyxxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param czybh 主键
     * @return 实例对象
     */
    XtCzyxx queryById(String czybh);

    /**
     * 通过登录账号查询数据
     *
     * @param dlzh 登录账号
     * @return 实例对象
     */
    List<XtCzyxx> queryByLogin(String dlzh);



    /**
     * 根据关键字查询
     *
     * @param findtext 查询关键字
     * @return 对象列表
     */
    List<XtCzyxx> queryAllByFilter(@Param("findtext") String findtext, @Param("offset") int offset, @Param("limit")int limit);


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryAllByFilterCount(@Param("findtext") String findtext);


    /**
     * 根据用户字段查询
     *
     * @param user 查询关键字
     * @return 对象列表
     */
    List<XtCzyxx> queryAll(@Param("user") XtCzyxx user);



    /**
     * 新增数据
     *
     * @param xtCzyxx 实例对象
     * @return 影响行数
     */
    int insert(XtCzyxx xtCzyxx);

    /**
     * 修改数据
     *
     * @param xtCzyxx 实例对象
     * @return 影响行数
     */
    int update(XtCzyxx xtCzyxx);

    /**
     * 通过主键删除数据
     *
     * @param czybh 主键
     * @return 影响行数
     */
    int deleteById(String czybh);

}