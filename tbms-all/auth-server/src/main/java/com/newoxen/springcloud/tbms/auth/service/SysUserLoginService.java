package com.newoxen.springcloud.tbms.auth.service;

import com.newoxen.springcloud.tbms.auth.dao.XtCzyxxDao;
import com.newoxen.springcloud.tbms.auth.entity.XtCzyxx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service("sysUserLoginService")
public class SysUserLoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserLoginService.class);

    @Resource
    XtCzyxxDao xtCzyxxDao;

    /**
     * 登录根据用户名查用户信息
     * @param UserName
     * @return
     */
    public XtCzyxx queryUserByName(String UserName){
        List<XtCzyxx> list_user = xtCzyxxDao.queryByLogin(UserName);
        if(list_user==null){
            return null;
        }else{
            return list_user.get(0);
        }
    }

    /**
     * 登录校验
     * @param loginaccount
     * @param passwd
     * @return
     */
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
     * 保存用户信息
     *
     * @param xtCzyxx 实例对象
     * @return UserId
     */
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public String saveUser(XtCzyxx xtCzyxx) {
        //根据userId判断新增还是修改
        String userId = xtCzyxx.getCzybh();
        //TODO: 安全处理
        //设置通用密码，通过修改密码保存
        xtCzyxx.setDlmm(null);

        if(userId==null || userId==""){
            //新建一个用户
            userId = UUID.randomUUID().toString();
            xtCzyxx.setCzybh(userId);
            System.out.println(userId);
            //TODO: 安全处理
            //新增设置默认密码
            String DEFAULT_PASSWD = "CHANGEPW_TBMS@NEWOXEN";
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            String hashPass = bcryptPasswordEncoder.encode(DEFAULT_PASSWD);
            LOGGER.info("DEFAULT_PASSWD=>"+hashPass);
            xtCzyxx.setDlmm(hashPass);

            this.xtCzyxxDao.insert(xtCzyxx);
        }else{
            //修改用户信息
            this.xtCzyxxDao.update(xtCzyxx);
        }

        return userId;
    }
}
