package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import com.newoxen.springcloud.tbms.admin.dao.XtGnxxDao;
import com.newoxen.springcloud.tbms.admin.service.SysFuncService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能信息（更新）(XtGnxx)表服务实现类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
@Service("xtGnxxService")
public class SysFuncServiceImpl implements SysFuncService {
    @Resource
    private XtGnxxDao xtGnxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param appid 主键
     * @return 实例对象
     */
    @Override
    public XtGnxx queryFuncById(String appid) {
        return this.xtGnxxDao.queryById(appid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtGnxx> queryAllFuncByPage(int offset, int limit) {
        return this.xtGnxxDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xtGnxx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtGnxx insertFunc(XtGnxx xtGnxx) {
        this.xtGnxxDao.insert(xtGnxx);
        return xtGnxx;
    }

    /**
     * 修改数据
     *
     * @param xtGnxx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtGnxx updateFunc(XtGnxx xtGnxx) {
        this.xtGnxxDao.update(xtGnxx);
        return this.queryFuncById(xtGnxx.getAppid());
    }

    /**
     * 通过主键删除数据
     *
     * @param appid 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean deleteFuncById(String appid) {
        return this.xtGnxxDao.deleteById(appid) > 0;
    }
}