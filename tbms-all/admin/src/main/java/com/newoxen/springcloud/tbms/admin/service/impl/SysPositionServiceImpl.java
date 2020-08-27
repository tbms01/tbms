package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtGwxx;
import com.newoxen.springcloud.tbms.admin.dao.XtGwxxDao;
import com.newoxen.springcloud.tbms.admin.service.SysPositionService;
import com.newoxen.springcloud.tbms.admin.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位信息(XtGwxx)表服务实现类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
@Service("xtGwxxService")
public class SysPositionServiceImpl implements SysPositionService {
    @Resource
    private XtGwxxDao xtGwxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param gwbh 主键
     * @return 实例对象
     */
    @Override
    public XtGwxx queryPositionById(String gwbh) {
        return this.xtGwxxDao.queryById(gwbh);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtGwxx> queryAllPositionByPage(int offset, int limit) {
        return this.xtGwxxDao.queryAllByLimit(offset, limit);
    }

    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    @Override
    public Integer queryCount(String findtext) {
        return xtGwxxDao.queryCount(findtext);
    }

    /**
     * 查询所有岗位id
     * @return
     */
    @Override
    public List<XtGwxx> queryAllPositionId() {
        return this.xtGwxxDao.queryAllId();
    }

    /**
     * 新增数据
     *
     * @param xtGwxx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtGwxx insertPosition(XtGwxx xtGwxx) {
        xtGwxx.setCjrbh(xtGwxx.getCzrbh());
        xtGwxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
        xtGwxx.setCjsj(DateUtils.getDate("yyyy-MM-dd"));
        xtGwxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
        this.xtGwxxDao.insert(xtGwxx);
        return xtGwxx;
    }

    /**
     * 修改数据
     *
     * @param xtGwxx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtGwxx updatePosition(XtGwxx xtGwxx) {
        //修改用户信息
        XtGwxx temp = xtGwxxDao.queryById(xtGwxx.getGwbh());
        if(!temp.getZtbgsj().equals(xtGwxx.getZtbgsj())){
            xtGwxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
        }
        xtGwxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
        this.xtGwxxDao.update(xtGwxx);
        return this.queryPositionById(xtGwxx.getGwbh());
    }

    /**
     * 通过主键删除数据
     *
     * @param gwbh 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean deletePositionById(String gwbh) {
        return this.xtGwxxDao.deleteById(gwbh) > 0;
    }
}