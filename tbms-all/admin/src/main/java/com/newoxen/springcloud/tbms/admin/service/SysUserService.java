package com.newoxen.springcloud.tbms.admin.service;

import com.github.pagehelper.Page;
import com.newoxen.springcloud.tbms.admin.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 操作员信息(XtCzyxx)表服务接口
 *
 * @author makejava
 * @since 2020-04-29 13:44:19
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param czybh 主键
     * @return 实例对象
     */
    XtCzyxx queryUserById(String czybh);

    /**
     * 根据关键字查询多条数据
     *
     * @param findtext 关键字
     * @return 对象列表
     */
    List<XtCzyxx> queryAllUserByFilter(String findtext, int offset, int limit);


    /**
     * 汇总行数
     * @param findtext
     * @return
     */
     Integer queryAllByFilterCount(String findtext);

    /**
     * 保存用户信息
     *
     * @param xtCzyxx 实例对象
     * @return userId
     */
    String saveUser(XtCzyxx xtCzyxx);

    /**
     * 通过主键删除数据
     *
     * @param czybh 主键
     * @return 是否成功
     */
    boolean deleteUserById(String czybh);

    /**
     * 登录
     * @param loginaccount
     * @param passwd
     * @return
     */
    XtCzyxx loginUser(String loginaccount, String passwd);

    /**
     * 修改密码
     * @param loginaccount
     * @param oldpass
     * @param newpasswd
     * @return
     */
    boolean changePassword(String loginaccount, String oldpass, String newpasswd);

}