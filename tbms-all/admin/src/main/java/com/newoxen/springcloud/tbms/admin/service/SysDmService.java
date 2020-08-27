package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.admin.entity.XtDm;
import java.util.List;

/**
 * 代码(XtDm)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 11:27:06
 */
public interface SysDmService {

    /**
     * 根据关键字查询多条数据
     *
     * @param findtext 关键字
     * @return 对象列表
     */
    List<XtDm> queryAllUserByFilter(String findtext, int offset, int limit);


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    Integer queryAllByFilterCount(String findtext);



    /**
     * 通过ID查询单条数据
     *
     * @param dmbh 主键
     * @return 实例对象
     */
    XtDm queryById(String dmbh);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtDm> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xtDm 实例对象
     * @return 实例对象
     */
    XtDm insert(XtDm xtDm);

    /**
     * 修改数据
     *
     * @param xtDm 实例对象
     * @return 实例对象
     */
    XtDm update(XtDm xtDm);

    /**
     * 通过主键删除数据
     *
     * @param dmbh 主键
     * @return 是否成功
     */
    boolean deleteById(String dmbh);

}