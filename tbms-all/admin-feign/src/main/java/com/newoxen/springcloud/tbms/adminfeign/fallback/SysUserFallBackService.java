package com.newoxen.springcloud.tbms.adminfeign.fallback;


import com.github.pagehelper.PageInfo;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.ResponseEntity;
import com.newoxen.springcloud.tbms.adminfeign.entity.ResponseUtil;
import com.newoxen.springcloud.tbms.adminfeign.feign.SysUserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 熔断调用失败降级处理类
 * @author gaowei
 */

@Service("sysUserFallBackService")
public class SysUserFallBackService implements SysUserFeignService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserFallBackService.class);

    @Override
    public ResponseEntity<XtCzyxx> queryUserInfo(String czybh) {

        return ResponseUtil.retErr(500,"queryUserInfo调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<List<XtCzyxx>> queryUserListPageLayUI(String findtext, Integer page, Integer limit) {
        return ResponseUtil.retErr(500,"queryUserListPageLayUI调用失败，服务被降级",null);
    }

    @Override
    public PageInfo<XtCzyxx> queryUserListPage(String findtext, Integer page_num, Integer page_size) {
        LOGGER.info("queryUserListPage调用失败，服务被降级");
        return null;
    }

    @Override
    public ResponseEntity<String> saveUser(XtCzyxx userInfo) {
        return ResponseUtil.retErr(500,"saveUser调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<XtCzyxx> loginUser(String dlzh, String pass) {
        return ResponseUtil.retErr(500,"loginUser调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<Boolean> changePassword(String dlzh, String old_pass, String new_pass) {
        return ResponseUtil.retErr(500,"changePassword调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<Boolean> deleteUser(String czybh) {
        return ResponseUtil.retErr(500,"deleteUser 调用失败，服务被降级",null);
    }
}
