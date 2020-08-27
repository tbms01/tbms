package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtSjqx;
import com.newoxen.springcloud.tbms.admin.dao.XtSjqxDao;
import com.newoxen.springcloud.tbms.admin.service.SysDataAccessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据权限(XtSjqx)表服务实现类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
@Service("xtSjqxService")
public class SysDataAccessServiceImpl implements SysDataAccessService {
    @Resource
    private XtSjqxDao xtSjqxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param appid 主键
     * @return 实例对象
     */
    @Override
    public XtSjqx queryDataAccessById(String appid) {
        return this.xtSjqxDao.queryById(appid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtSjqx> queryAllDataAccessByPage(int offset, int limit) {
        return this.xtSjqxDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xtSjqx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtSjqx insertDataAccess(XtSjqx xtSjqx) {
        this.xtSjqxDao.insert(xtSjqx);
        return xtSjqx;
    }

    /**
     * 修改数据
     *
     * @param xtSjqx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtSjqx updateDataAccess(XtSjqx xtSjqx) {
        this.xtSjqxDao.update(xtSjqx);
        return this.queryDataAccessById(xtSjqx.getAppid());
    }

    /**
     * 通过主键删除数据
     *
     * @param appid 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean deleteDataAccessById(String appid) {
        return this.xtSjqxDao.deleteById(appid) > 0;
    }
}