package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import com.newoxen.springcloud.tbms.admin.entity.XtJsxx;
import com.newoxen.springcloud.tbms.admin.dao.XtJsxxDao;
import com.newoxen.springcloud.tbms.admin.service.SysRoleService;
import com.newoxen.springcloud.tbms.admin.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息(XtJsxx)表服务实现类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
@Service("xtJsxxService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private XtJsxxDao xtJsxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param jsbh 主键
     * @return 实例对象
     */
    @Override
    public XtJsxx queryRoleById(String jsbh) {
        return this.xtJsxxDao.queryById(jsbh);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<XtJsxx> queryAllRoleByPage(int offset, int limit) {
        return this.xtJsxxDao.queryAllByLimit(offset, limit);
    }


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    @Override
    public Integer queryCount(String findtext) {
        return xtJsxxDao.queryCount(findtext);
    }
    /**
     * 新增数据
     *
     * @param xtJsxx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtJsxx insertRole(XtJsxx xtJsxx) {
        xtJsxx.setCjrbh(xtJsxx.getCzrbh());
        xtJsxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
        xtJsxx.setCjsj(DateUtils.getDate("yyyy-MM-dd"));
        xtJsxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
        this.xtJsxxDao.insert(xtJsxx);
        return xtJsxx;
    }

    /**
     * 修改数据
     *
     * @param xtJsxx 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtJsxx updateRole(XtJsxx xtJsxx) {
        //修改用户信息
        XtJsxx temp = xtJsxxDao.queryById(xtJsxx.getJsbh());
        if(!temp.getZtbgsj().equals(xtJsxx.getZtbgsj())){
            xtJsxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
        }
        xtJsxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
        this.xtJsxxDao.update(xtJsxx);
        return this.queryRoleById(xtJsxx.getJsbh());
    }

    /**
     * 通过主键删除数据
     *
     * @param jsbh 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean deleteRoleById(String jsbh) {
        return this.xtJsxxDao.deleteById(jsbh) > 0;
    }


}