package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtDm;
import com.newoxen.springcloud.tbms.admin.dao.XtDmDao;
import com.newoxen.springcloud.tbms.admin.service.SysDmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 代码(XtDm)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 11:27:06
 */
@Service("xtDmService")
public class SysDmServiceImpl implements SysDmService {
    @Resource
    private XtDmDao xtDmDao;

    @Override
    public List<XtDm> queryAllUserByFilter(String findtext, int offset, int limit) {
        return xtDmDao.queryAllByFilter(findtext, offset, limit);
    }

    @Override
    public Integer queryAllByFilterCount(String findtext) {
        return xtDmDao.queryAllByFilterCount(findtext);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param dmbh 主键
     * @return 实例对象
     */
    @Override
    public XtDm queryById(String dmbh) {
        return this.xtDmDao.queryById(dmbh);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtDm> queryAllByLimit(int offset, int limit) {
        return this.xtDmDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xtDm 实例对象
     * @return 实例对象
     */
    @Override
    public XtDm insert(XtDm xtDm) {
        this.xtDmDao.insert(xtDm);
        return xtDm;
    }

    /**
     * 修改数据
     *
     * @param xtDm 实例对象
     * @return 实例对象
     */
    @Override
    public XtDm update(XtDm xtDm) {
        this.xtDmDao.update(xtDm);
        return this.queryById(xtDm.getDmbh());
    }

    /**
     * 通过主键删除数据
     *
     * @param dmbh 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String dmbh) {
        return this.xtDmDao.deleteById(dmbh) > 0;
    }
}