package com.newoxen.springcloud.tbms.admin.controller;


import com.newoxen.springcloud.tbms.admin.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import com.newoxen.springcloud.tbms.admin.entity.XtJsxx;
import com.newoxen.springcloud.tbms.admin.service.SysAuthAccessService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/auth_access")
public class SysAuthAccessController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysAuthAccessController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysAuthAccessService sysAuthAccessService;

    /**
     * 查询用户具备权限的功能菜单
     * @param gwbh
     * @return
     */
    @RequestMapping("/query_func_all")
    public List<XtGnxx> queryUserInfo(String sjgnbh, String gwbh){
        try{
            List<XtGnxx> list_user_info = sysAuthAccessService.queryFuncAllChildren(sjgnbh,gwbh);
            return list_user_info;
        }catch (Exception ex){
            LOGGER.error("【API sys/role/query_list_user_info_page错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 查询一个岗位下的所有功能详细信息
     * @return
     */
    @RequestMapping("/query_func_list")
    public ResponseEntity<List<XtGnxx>> queryRoleList(String gwbh,String jsbh){

        try{
            ResponseEntity<List<XtGnxx>> ret_data = new ResponseEntity<>();
            List<XtGnxx> list_func = sysAuthAccessService.queryAllFuncsByPosition(gwbh,jsbh);
            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_func);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/query_func_list错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 查询一个角色下的所有功能详细信息
     * @return
     */
    @RequestMapping("/query_func_list_role_no")
    public ResponseEntity<List<XtGnxx>> queryFuncListByRole(String jsbh){

        try{
            ResponseEntity<List<XtGnxx>> ret_data = new ResponseEntity<>();
            List<XtGnxx> list_func = sysAuthAccessService.queryAllFuncsByPosition(jsbh);
            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_func);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/query_func_list错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 查询一个岗位下的所有角色信息
     * @param gwbh
     * @return
     */
    @RequestMapping("/query_role_list")
    public ResponseEntity<List<XtJsxx>> queryAllRoleByPosition(String gwbh){

        try{
            ResponseEntity<List<XtJsxx>> ret_data = new ResponseEntity<>();
            List<XtJsxx> list_role = sysAuthAccessService.queryAllRolesByPosition(gwbh);
            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_role);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/query_role_list错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 查询不属于该岗位下的所有角色信息
     * @param gwbh
     * @return
     */
    @RequestMapping("/query_role_list_no")
    public ResponseEntity<List<XtJsxx>> queryAllRoleByPositionNo(String gwbh){
        //System.out.println(gwbh);
        try{
            ResponseEntity<List<XtJsxx>> ret_data = new ResponseEntity<>();
            List<XtJsxx> list_role = sysAuthAccessService.queryAllRolesByPositionNo(gwbh);
            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_role);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/query_role_list_no错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 新增数据
     *
     * @param jsbh
     * @param gnbh
     * @return 实例对象
     */
    @PostMapping("/insert_role_func")
    public boolean addRoleFunc(String jsbh, String gnbh){
        return this.sysAuthAccessService.addRoleFunc(jsbh,gnbh);
    }

    /**
     * 新增岗位角色关系
     *
     * @param gwbh
     * @param listJsbh
     * @return 实例对象
     */
    @PostMapping("/add_role_position")
    public ResponseEntity<Boolean> addRolePosition(String gwbh, List<String> listJsbh, String czybh){
        if(czybh==null || czybh==""){
            return ResponseUtil.retErr("操作人编号不能为空");
        }
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }
        if(listJsbh==null){
            return ResponseUtil.retErr("角色编号不能为空");
        }
        try{
            if(this.sysAuthAccessService.addRolePosition(gwbh,listJsbh,czybh)){
                return ResponseUtil.retOK(true, "添加成功");
            }else{
                return ResponseUtil.retErr("添加错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 新增角色功能关系
     *
     * @param jsbh
     * @param listGnbh
     * @return 实例对象
     */
    @PostMapping("/add_role_func")
    public ResponseEntity<Boolean> addRoleFunc(String jsbh, List<String> listGnbh, String czybh){
        if(czybh==null || czybh==""){
            return ResponseUtil.retErr("操作人编号不能为空");
        }
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }
        if(listGnbh==null){
            return ResponseUtil.retErr("功能编号不能为空");
        }
        try{
            if(this.sysAuthAccessService.addFuncRole(jsbh,listGnbh,czybh)){
                return ResponseUtil.retOK(true, "添加成功");
            }else{
                return ResponseUtil.retErr("添加错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 通过功能编号和角色编号移除功能和角色关系
     * @param jsbh,gnbh
     * @return 是否成功
     */
    @RequestMapping("/remove_role_func")
    public ResponseEntity<Boolean> removeRoleFunc(String jsbh, String gnbh){
        if(gnbh==null || gnbh==""){
            return ResponseUtil.retErr("功能编号不能为空");
        }
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }
        try{
            if(this.sysAuthAccessService.removeRoleFunc(jsbh,gnbh)){
                return ResponseUtil.retOK(true, "移除角色成功");
            }else{
                return ResponseUtil.retErr("移除角色错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 通过岗位编号和角色编号移除岗位和角色关系
     * @param jsbh,gwbh
     * @return 是否成功
     */
    @RequestMapping("/remove_position_role")
    public ResponseEntity<Boolean> removePositionRole(String gwbh, String jsbh){
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }

        try{
            if(this.sysAuthAccessService.removePositionRole(gwbh,jsbh)){
                return ResponseUtil.retOK(true, "移除角色成功");
            }else{
                return ResponseUtil.retErr("移除角色错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 移除角色下全部功能
     * @param jsbh
     * @return
     */
    @PostMapping("/delete_role")
    public boolean removeAllRoleFunc(String jsbh){
        return this.sysAuthAccessService.removeAllRoleFunc(jsbh);
    }
}
