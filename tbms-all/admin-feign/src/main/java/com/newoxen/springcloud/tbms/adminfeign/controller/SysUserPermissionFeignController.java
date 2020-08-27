package com.newoxen.springcloud.tbms.adminfeign.controller;

import com.newoxen.springcloud.tbms.adminfeign.entity.XtGnxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtGwxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtJsxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.ResponseEntity;
import com.newoxen.springcloud.tbms.adminfeign.feign.SysUserPermissionFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户授权Feign控制类
 * 用于封装用户岗位-角色-功能权限
 *
 * @author gaowei
 */

@RestController
@RequestMapping("/permission")
public class SysUserPermissionFeignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserPermissionFeignController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysUserPermissionFeignService sysUserPermissionFeignService;

    /**
     * 查询用户的岗位信息
     * @param gwbh 岗位编号
     * @return
     */
    @RequestMapping("query_position")
    public ResponseEntity<XtGwxx> queryPositionByUser(String gwbh){
        return sysUserPermissionFeignService.queryPositionByUser(gwbh);
    }

    /**
     * 查询一个岗位对应角色
     * @param gwbh
     * @return
     */
    @RequestMapping("query_roles")
    public ResponseEntity<List<XtJsxx>> queryAllRolesByPosition(String gwbh){
        return sysUserPermissionFeignService.queryAllRolesByPosition(gwbh);
    }

    /**
     * 查询一个岗位对应功能
     * @param gwbh
     * @return
     */
    @RequestMapping("query_accessfuncs")
    public ResponseEntity<List<XtGnxx>> queryAllFuncsByPosition(String gwbh){
        return sysUserPermissionFeignService.queryAllFuncsByPosition(gwbh);
    }



    /**
     * 删除一个角色对应权限
     * @param jsbh
     * @return
     */
    @RequestMapping("remove_rolefuncs")
    public ResponseEntity<Boolean> removeRoleFuncs(String jsbh){
        return sysUserPermissionFeignService.removeRoleFuncs(jsbh);
    }

    /**
     * 添加权限
     * @param jsbh
     * @param gnbh
     * @return
     */
    @RequestMapping("add_accessfuncs")
    public ResponseEntity<Boolean> addRoleFunc(@RequestParam("jsbh")String jsbh,
                                               @RequestParam("gnbh")String gnbh){
        return sysUserPermissionFeignService.addRoleFunc(jsbh, gnbh);
    }


}
