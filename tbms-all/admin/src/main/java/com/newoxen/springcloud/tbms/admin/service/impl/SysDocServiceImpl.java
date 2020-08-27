package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtFjxx;
import com.newoxen.springcloud.tbms.admin.dao.XtFjxxDao;
import com.newoxen.springcloud.tbms.admin.service.SysDocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 附件信息(XtFjxx)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 11:31:18
 */
@Service("xtFjxxService")
public class SysDocServiceImpl implements SysDocService {
    @Resource
    private XtFjxxDao xtFjxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fjbh 主键
     * @return 实例对象
     */
    @Override
    public XtFjxx queryById(String fjbh) {
        return this.xtFjxxDao.queryById(fjbh);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtFjxx> queryAllByLimit(int offset, int limit) {
        return this.xtFjxxDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xtFjxx 实例对象
     * @return 实例对象
     */
    @Override
    public XtFjxx insert(XtFjxx xtFjxx) {
        this.xtFjxxDao.insert(xtFjxx);
        return xtFjxx;
    }

    /**
     * 修改数据
     *
     * @param xtFjxx 实例对象
     * @return 实例对象
     */
    @Override
    public XtFjxx update(XtFjxx xtFjxx) {
        this.xtFjxxDao.update(xtFjxx);
        return this.queryById(xtFjxx.getFjbh());
    }

    /**
     * 通过主键删除数据
     *
     * @param fjbh 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String fjbh) {
        return this.xtFjxxDao.deleteById(fjbh) > 0;
    }
}