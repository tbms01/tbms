package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.entity.XtFjxx;
import java.util.List;

/**
 * 附件信息(XtFjxx)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 11:31:18
 */
public interface SysDocService {

    /**
     * 通过ID查询单条数据
     *
     * @param fjbh 主键
     * @return 实例对象
     */
    XtFjxx queryById(String fjbh);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<XtFjxx> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param xtFjxx 实例对象
     * @return 实例对象
     */
    XtFjxx insert(XtFjxx xtFjxx);

    /**
     * 修改数据
     *
     * @param xtFjxx 实例对象
     * @return 实例对象
     */
    XtFjxx update(XtFjxx xtFjxx);

    /**
     * 通过主键删除数据
     *
     * @param fjbh 主键
     * @return 是否成功
     */
    boolean deleteById(String fjbh);

}