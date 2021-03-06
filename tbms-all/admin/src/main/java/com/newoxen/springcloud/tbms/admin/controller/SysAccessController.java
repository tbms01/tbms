package com.newoxen.springcloud.tbms.admin.controller;


import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import com.newoxen.springcloud.tbms.admin.entity.XtGwxx;
import com.newoxen.springcloud.tbms.admin.entity.XtJsxx;
import com.newoxen.springcloud.tbms.admin.service.SysAuthAccessService;
import com.newoxen.springcloud.tbms.admin.service.SysPositionService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户授权控制类
 * 用于封装用户岗位-角色-功能权限
 *
 * @author gaowei
 */

@RestController
@RequestMapping("/admin")
public class SysAccessController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysPositionService sysPositionService;
    @Autowired
    private SysAuthAccessService sysAuthAccessService;


    /**
     * 查询一个用户具备权限的全部应用
     * @param gwbh
     * @return
     */
    @RequestMapping("query_access_applications")
    public ResponseEntity<List<XtGnxx>> queryUserApplications(String gwbh){
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }

        try{
            //TODO: 上级岗位为零代表系统
            return ResponseUtil.retOK(sysAuthAccessService.queryApplication(gwbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 查询一个用户具备权限的菜单下级
     * @param sjgnbh 上级功能编号
     * @param gwbh 岗位编号（用户）
     * @return
     */
    @RequestMapping("query_access_children")
    public ResponseEntity<List<XtGnxx>> queryUserFuncChildren(String  sjgnbh, String gwbh){
        if(sjgnbh==null || sjgnbh==""){
            return ResponseUtil.retErr("上级功能编号不能为空");
        }
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }

        try{
            //TODO: 上级岗位为零代表系统
            return ResponseUtil.retOK(sysAuthAccessService.queryFuncAllChildren(sjgnbh, gwbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }


    /**
     * 查询用户的岗位信息
     * @param gwbh 岗位编号
     * @return
     */
    @RequestMapping("query_access_position")
    public ResponseEntity<XtGwxx> queryPositionByUser(String gwbh){
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysPositionService.queryPositionById(gwbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 查询一个岗位对应角色
     * @param gwbh
     * @return
     */
    @RequestMapping("query_access_roles")
    public ResponseEntity<List<XtJsxx>> queryAllRolesByPosition(String gwbh){
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysAuthAccessService.queryAllRolesByPosition(gwbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 删除一个角色对应权限
     * @param jsbh
     * @return
     */
    @RequestMapping("remove_access_rolefuncs")
    public ResponseEntity<Boolean> removeRoleFuncs(String jsbh){
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }
        try{
            return ResponseUtil.retOK(sysAuthAccessService.removeAllRoleFunc(jsbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 添加权限
     * @param jsbh
     * @param gnbh
     * @return
     */
    @RequestMapping("add_access_funcs")
    public ResponseEntity<Boolean> addRoleFunc(String jsbh, String gnbh){
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }
        if(gnbh==null || gnbh==""){
            return ResponseUtil.retErr("功能编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysAuthAccessService.addRoleFunc(jsbh, gnbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }


}
