package com.newoxen.springcloud.tbms.adminfeign.fallback;


import com.newoxen.springcloud.tbms.adminfeign.entity.*;
import com.newoxen.springcloud.tbms.adminfeign.feign.SysUserPermissionFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断调用失败降级处理类
 * @author gaowei
 */

@Component
public class SysUserPermissionFallBackService implements SysUserPermissionFeignService {
    @Override
    public ResponseEntity<XtGwxx> queryPositionByUser(String gwbh) {
        return ResponseUtil.retErr(500,"调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<List<XtJsxx>> queryAllRolesByPosition(String gwbh) {
        return ResponseUtil.retErr(500,"调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<List<XtGnxx>> queryAllFuncsByPosition(String gwbh) {
        return ResponseUtil.retErr(500,"调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<Boolean> removeRoleFuncs(String jsbh) {
        return ResponseUtil.retErr(500,"调用失败，服务被降级",null);
    }

    @Override
    public ResponseEntity<Boolean> addRoleFunc(String jsbh, String gnbh) {
        return ResponseUtil.retErr(500,"调用失败，服务被降级",null);
    }
}
