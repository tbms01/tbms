package com.newoxen.springcloud.tbms.admin.service.impl;

import com.github.pagehelper.Page;
import com.newoxen.springcloud.tbms.admin.controller.SysUserController;
import com.newoxen.springcloud.tbms.admin.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.admin.dao.XtCzyxxDao;
import com.newoxen.springcloud.tbms.admin.service.SysUserService;
import com.newoxen.springcloud.tbms.admin.util.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * 操作员信息(XtCzyxx)表服务实现类
 * 昆明鑫牛科技有限公司(C)2015
 *
 * @author zm
 * @since 2020-04-29 13:44:19
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    @Resource
    private XtCzyxxDao xtCzyxxDao;

    /**
     * 通过ID查询单条数据
     *
     * @param czybh 主键
     * @return 实例对象
     */
    @Override
    public XtCzyxx queryUserById(String czybh) {
        return this.xtCzyxxDao.queryById(czybh);
    }



    /**
     * 分页查询多条数据
     *
     * @param findtext 关键字
     * @return 对象列表
     */
    @Override
    public List<XtCzyxx> queryAllUserByFilter(String findtext, int offset, int limit) {
        return this.xtCzyxxDao.queryAllByFilter(findtext, offset, limit);
    }

    /**
     * 汇总行数
     * @param findtext
     * @return
     */
    @Override
    public Integer queryAllByFilterCount(String findtext) {
        return xtCzyxxDao.queryAllByFilterCount(findtext);
    }

    /**
     * 保存用户信息
     *
     * @param xtCzyxx 实例对象
     * @return UserId
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String saveUser(XtCzyxx xtCzyxx) {
        //根据userId判断新增还是修改
        XtCzyxx temp = xtCzyxxDao.queryById(xtCzyxx.getCzybh());
        String userId = xtCzyxx.getCzybh();
        //TODO: 安全处理
        //设置通用密码，通过修改密码保存
        xtCzyxx.setDlmm(null);

        if(temp==null ){
            //新建一个用户
            userId = UUID.randomUUID().toString().replaceAll("-","");
            xtCzyxx.setCzybh(userId);
            System.out.println(userId);
            //TODO: 安全处理
            //新增设置默认密码
            String DEFAULT_PASSWD = "CHANGEPW_TBMS@NEWOXEN";
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashPass = bcryptPasswordEncoder.encode(DEFAULT_PASSWD);
            LOGGER.info("DEFAULT_PASSWD=>"+hashPass);
            xtCzyxx.setDlmm(hashPass);

            xtCzyxx.setCjrbh(xtCzyxx.getCzrbh());
            xtCzyxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
            xtCzyxx.setCjsj(DateUtils.getDate("yyyy-MM-dd"));
            xtCzyxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
            xtCzyxx.setDlmmycwcs(0);
            xtCzyxx.setDlmmzdcwcs(5);//最大错误数
            this.xtCzyxxDao.insert(xtCzyxx);
        }else{
            //修改用户信息
            if(!temp.getZtbgsj().equals(xtCzyxx.getZtbgsj())){
                xtCzyxx.setZtbgsj(DateUtils.getDate("yyyy-MM-dd"));
            }
            xtCzyxx.setCzsj(DateUtils.getDate("yyyy-MM-dd"));
            this.xtCzyxxDao.update(xtCzyxx);
        }

        return userId;
    }


    /**
     * 通过主键删除数据
     *
     * @param czybh 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean deleteUserById(String czybh) {
        return this.xtCzyxxDao.deleteById(czybh) > 0;
    }


    /**
     * 登录校验
     * @param loginaccount
     * @param passwd
     * @return
     */
    @Override
    public XtCzyxx loginUser(String loginaccount, String passwd) {
        System.out.println(loginaccount);
        System.out.println(passwd);
        if(loginaccount==null || loginaccount==""){
            LOGGER.error("登录账户不能为空");
            return null;
        }
        if(passwd==null || passwd==""){
            LOGGER.error("登录密码不能为空");
            return null;
        }

        List<XtCzyxx> list_user = xtCzyxxDao.queryByLogin(loginaccount);
        if(list_user==null || list_user.size()<1){
            LOGGER.error("登录账户不存在");
            return null;
        }

        if(list_user.size()>1){
            LOGGER.error("登录账户"+loginaccount+"不唯一");
        }

        XtCzyxx userLogin = list_user.get(0);
        String crypyPass = userLogin.getDlmm().trim();
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String loginPass = bcryptPasswordEncoder.encode(passwd);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //LOGGER.info("[loginpass]=>"+loginPass + "  [dbpass]=>"+crypyPass+"  match=>"+bcryptPasswordEncoder.matches(passwd, crypyPass));

        if (bcryptPasswordEncoder.matches(passwd, crypyPass)) {
            //修改登录出错次数
            userLogin.setDlmmycwcs(0);
            userLogin.setZtbgsj(sdf.format(System.currentTimeMillis()));
            this.saveUser(userLogin);

            //TODO：安全处理
            //不返回字段处理
            userLogin.setDlmm("");
            return userLogin;

        }else{
            //增加登录出错次数
            if(userLogin.getDlmmycwcs() < userLogin.getDlmmzdcwcs()){
                userLogin.setDlmmycwcs(userLogin.getDlmmycwcs()+1);
            }
            userLogin.setZtbgsj(sdf.format(System.currentTimeMillis()));
            this.saveUser(userLogin);
            LOGGER.error(loginaccount+"登录密码错误");
            return null;
        }
    }


    /**
     * 修改密码
     * @param loginaccount
     * @param oldpass
     * @param newpasswd
     * @return
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public boolean changePassword(String loginaccount, String oldpass, String newpasswd) {

        if(loginaccount==null || loginaccount==""){
            LOGGER.error("登录账户不能为空");
            return false;
        }
        if(oldpass==null || oldpass==""){
            LOGGER.error("登录账户不能为空");
            return false;
        }

        if(this.loginUser(loginaccount, oldpass)==null){
            LOGGER.error("旧密码错误");
            return false;
        }

        List<XtCzyxx> list_user = xtCzyxxDao.queryByLogin(loginaccount);
        if(list_user==null || list_user.size()<1){
            LOGGER.error("登录账户不存在");
            return false;
        }

        if(list_user.size()>1){
            LOGGER.error("登录账户"+loginaccount+"不唯一");
        }

        //更新密码
        XtCzyxx userChangPass = list_user.get(0);
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String changePass = bcryptPasswordEncoder.encode(newpasswd);

        userChangPass.setDlmm(changePass);
        this.xtCzyxxDao.update(userChangPass);

        return true;
    }

}