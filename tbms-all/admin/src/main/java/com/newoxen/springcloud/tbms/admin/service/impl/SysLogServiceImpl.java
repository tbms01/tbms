package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtCzjl;
import com.newoxen.springcloud.tbms.admin.dao.XtCzjlDao;
import com.newoxen.springcloud.tbms.admin.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作记录（更新）(XtCzjl)表服务实现类
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
@Service("sysLogServiceImpl")
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private XtCzjlDao xtCzjlDao;

    /**
     * 通过ID查询单条数据
     *
     * @param czlsh 主键
     * @return 实例对象
     */
    @Override
    public XtCzjl queryActionLogById(Long czlsh) {
        return this.xtCzjlDao.queryById(czlsh);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtCzjl> queryActionLogAllByPage(int offset, int limit) {
        return this.xtCzjlDao.queryAllByLimit(offset, limit);
    }

    @Override
    public XtCzjl addLog(XtCzjl xtCzjl) {
        return null;
    }

}