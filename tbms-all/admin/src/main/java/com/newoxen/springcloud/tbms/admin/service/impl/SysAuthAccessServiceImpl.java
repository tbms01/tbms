package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.dao.XtGwjsgxDao;
import com.newoxen.springcloud.tbms.admin.entity.*;
import com.newoxen.springcloud.tbms.admin.dao.XtJsgngxDao;
import com.newoxen.springcloud.tbms.admin.service.SysAuthAccessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 角色功能关系(XtJsgngx)表服务实现类
 *
 * @author makejava
 * @since 2020-04-29 13:44:20
 */
@Service("xtJsgngxService")
public class SysAuthAccessServiceImpl implements SysAuthAccessService {
    @Resource
    private XtJsgngxDao xtJsgngxDao;

    @Resource
    private XtGwjsgxDao xtGwjsgxDao;


    /**
     * 查询用户具备权限应用
     * @param gwbh
     * @return
     */
    @Override
    public List<XtGnxx> queryApplication(String gwbh) {
        return this.xtGwjsgxDao.queryApplication(gwbh);
    }

    /**
     * 查询用户具备权限功能菜单所有但钱下级
     * @param sjgnbh
     * @param gwbh
     * @return
     */
    @Override
    public List<XtGnxx> queryFuncAllChildren(String sjgnbh, String gwbh) {
        return this.xtGwjsgxDao.queryFuncAllChildren(sjgnbh, gwbh);
    }

    /**
     * 查询一个岗位下所有功能权限
     * @param gwbh 岗位编号
     * @return
     */
    @Override
    public List<XtGnxx> queryAllFuncsByPosition(String gwbh, String jsbh) {
        return this.xtGwjsgxDao.queryAllFuncsByPosition(gwbh,jsbh);
    }

    /**
     * 查询一个角色下所有功能权限
     * @param jsbh
     * @return
     */
    @Override
    public List<XtGnxx> queryAllFuncsByPosition( String jsbh) {
        return this.xtGwjsgxDao.queryAllFuncsByRoleNo(jsbh);
    }

    /**
     * 查询一个岗位全部角色
     *
     * @param gwbh 岗位编号
     * @return 功能列表
     */
    @Override
    public List<XtJsxx> queryAllRolesByPosition(String gwbh){
        return this.xtGwjsgxDao.queryAllRolesByPosition(gwbh);
    }


    /**
     * 查询不属于该岗位的全部角色
     *
     * @param gwbh 岗位编号
     * @return 功能列表
     */
    @Override
    public List<XtJsxx> queryAllRolesByPositionNo(String gwbh){
        return this.xtGwjsgxDao.queryAllRolesByPositionNo(gwbh);
    }


    /**
     * 新增数据
     *
     * @param jsbh
     * @param gnbh
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean addRoleFunc(String jsbh, String gnbh){
        XtJsgngx jsgngx = new XtJsgngx();
        jsgngx.setJsbh(jsbh);
        jsgngx.setGnbh(gnbh);
        return this.xtJsgngxDao.insert(jsgngx)>0;
    }

    /**
     * 新增数据
     *
     * @param jsbh
     * @param listGnbh
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean addFuncRole(String jsbh, List<String> listGnbh, String czybh){
        List<XtJsgngx> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String gnbh:listGnbh) {
            XtJsgngx jsgngx = new XtJsgngx();
            jsgngx.setJsbh(jsbh);
            jsgngx.setGnbh(gnbh);
            jsgngx.setCzrbh(czybh);
            jsgngx.setCzsj(sdf.format(System.currentTimeMillis()));
            list.add(jsgngx);
        }
        return xtJsgngxDao.add(list)>0;
    }
    /**
     * 通过主键删除数据
     *
     * @param jsbh
     * @param gnbh
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean removeRoleFunc(String jsbh, String gnbh){
        return this.xtJsgngxDao.deleteById(jsbh, gnbh)>0;
    }

    /**
     * 移除角色下全部功能
     * @param jsbh
     * @return
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean removeAllRoleFunc(String jsbh){
        return this.xtJsgngxDao.deleteAllByRole(jsbh)>0;
    }



    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public XtGwjsgx addPositionRole(XtGwjsgx xtGwjsgx) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean removePositionRole(String gwbh, String jsbh) {
        return this.xtGwjsgxDao.deletePositionRole(gwbh, jsbh);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean removeAllPositionRole(String gwbh) {
        return false;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean addRolePosition(String gwbh, List<String> listJsbh,String czybh) {
        List<XtGwjsgx> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String jsbh:listJsbh) {
            XtGwjsgx gwjsgx = new XtGwjsgx();
            gwjsgx.setGwbh(gwbh);
            gwjsgx.setJsbh(jsbh);
            gwjsgx.setCzrbh(czybh);
            gwjsgx.setCzsj(sdf.format(System.currentTimeMillis()));
            list.add(gwjsgx);
        }
        return xtGwjsgxDao.insert(list)>0;
    }
}