package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.entity.LayUITree;
import com.newoxen.springcloud.tbms.admin.entity.XtGwxx;
import com.newoxen.springcloud.tbms.admin.entity.XtZzxx;
import com.newoxen.springcloud.tbms.admin.dao.XtZzxxDao;
import com.newoxen.springcloud.tbms.admin.entity.XtZzxxExtend;
import com.newoxen.springcloud.tbms.admin.service.SysOrgService;
import com.newoxen.springcloud.tbms.admin.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 组织信息(XtZzxx)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 11:29:44
 */
@Service("xtZzxxService")
public class SysOrgServiceImpl implements SysOrgService {
    @Resource
    private XtZzxxDao xtZzxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param zzbm 主键
     * @return 实例对象
     */
    @Override
    public XtZzxx queryById(String zzbm) {
        return this.xtZzxxDao.queryById(zzbm);
    }

    /**
     * 查询所有组织
     * @return
     */
    @Override
    public List<XtZzxx> queryAll() {
        return this.xtZzxxDao.queryAllOrg();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<XtZzxx> queryAllByLimit(int offset, int limit) {
        return this.xtZzxxDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param xtZzxx 实例对象
     * @return 实例对象
     */
    @Override
    public XtZzxx insert(XtZzxx xtZzxx) {
        this.xtZzxxDao.insert(xtZzxx);
        return xtZzxx;
    }

    /**
     * 修改数据
     *
     * @param xtZzxx 实例对象
     * @return 实例对象
     */
    @Override
    public XtZzxx update(XtZzxx xtZzxx) {
        this.xtZzxxDao.update(xtZzxx);
        return this.queryById(xtZzxx.getZzbm());
    }

    /**
     * 通过主键删除数据
     *
     * @param zzbm 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String zzbm) {
        return this.xtZzxxDao.deleteById(zzbm) > 0;
    }

    /**
     * 分页查询多条数据
     *
     * @param findtext 关键字
     * @return 对象列表
     */
    @Override
    public List<XtZzxx> queryAllUserByFilter(String findtext, int offset, int limit) {
        return this.xtZzxxDao.queryAllByFilter(findtext, offset, limit);
    }

    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    @Override
    public Integer queryAllByFilterCount(String findtext, int offset, int limit) {
        return xtZzxxDao.queryAllByFilterCount(findtext, offset, limit);
    }

    /**
     * 根据父级过滤查询
     *
     * @param sjzzbm 关键字
     * @return 对象列表
     */
    @Override
    public List<LayUITree> queryAllByFather(String sjzzbm) {
        List<XtZzxxExtend> list = this.xtZzxxDao.queryAllByFather(sjzzbm);

        List<LayUITree> tree_org = new ArrayList<>();

        for (XtZzxxExtend item : list ) {
            LayUITree tree = new LayUITree();
            tree.setId(item.getZzbm());
            tree.setTitle(item.getZzmc());

            List<LayUITree> list_org = queryAllByFather(tree.getId());
            tree.setChildren(list_org);

            tree_org.add(tree);
        }

        return tree_org;
    }

    /**
     * 根据父级过滤查询
     *
     * @param sjzzbm 关键字
     * @return 对象列表
     */
    @Override
    public List<XtZzxxExtend> queryAllByFatherPager(String sjzzbm, int offset, int limit) {
        return this.xtZzxxDao.queryAllByFatherPager(sjzzbm, offset, limit);
    }

    /**
     * 根据父级过滤查询-汇总行数
     * @param sjzzbm
     * @return
     */
    @Override
    public Integer queryAllByFatherPagerCount(String sjzzbm, int offset, int limit) {
        return xtZzxxDao.queryAllByFatherPagerCount(sjzzbm, offset, limit);
    }

    /**
     * 保存组织信息
     *
     * @param xtZzxx 实例对象
     * @return
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String saveOrg(XtZzxx xtZzxx) {
        //根据userId判断新增还是修改
        XtZzxx temp = xtZzxxDao.queryById(xtZzxx.getZzbm());

        if(temp==null){
            xtZzxx.setCjrbh(xtZzxx.getCzrbh());
            xtZzxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
            xtZzxx.setCjsj(DateUtils.getDate("yyyy-MM-dd"));
            xtZzxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
            this.xtZzxxDao.insert(xtZzxx);
        }else{
            //修改信息
            //修改用户信息
            if(!temp.getZtbgsj().equals(xtZzxx.getZtbgsj())){
                xtZzxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
            }
            xtZzxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
            this.xtZzxxDao.update(xtZzxx);
        }

        return xtZzxx.getZzbm();
    }

}