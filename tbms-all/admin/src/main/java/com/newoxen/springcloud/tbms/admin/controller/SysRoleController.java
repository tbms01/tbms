package com.newoxen.springcloud.tbms.admin.controller;


import com.newoxen.springcloud.tbms.admin.entity.XtJsxx;
import com.newoxen.springcloud.tbms.admin.service.SysRoleService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class SysRoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 查询角色详细信息
     * @param jsbh
     * @return
     */
    @RequestMapping("/query_role_info")
    public ResponseEntity<XtJsxx> queryUserInfo(String jsbh){
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysRoleService.queryRoleById(jsbh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 查询角色详细信息
     * @return
     */
    @RequestMapping("/query_role_list_page")
    public ResponseEntity<List<XtJsxx>> queryRoleList(String findtext,int page, int limit){
        if(page<1){
            page = 1; //默认开始页
        }
        if(limit<1){
            limit = 10; //默认每页大小
        }
        int offset = (page-1)*limit;
        try{
            ResponseEntity<List<XtJsxx>> ret_data = new ResponseEntity<>();
            List<XtJsxx> list_role = sysRoleService.queryAllRoleByPage(offset,limit);
            Integer list_count = sysRoleService.queryCount(findtext);
            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_role);
            ret_data.setCount(list_count);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/role/query_roleList_page错误】："+ex.getMessage());
            return null;
        }
    }


    /**
     * 新增角色信息
     * @param xtJsxx
     * @return
     */
    @PostMapping("/insert_role")
    public ResponseEntity<XtJsxx> insertRole(XtJsxx xtJsxx){

        if(xtJsxx==null){
            return ResponseUtil.retErr("角色信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysRoleService.insertRole(xtJsxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 修改角色信息
     * @param xtJsxx
     * @return
     */
    @PostMapping("/update_role")
    public ResponseEntity<XtJsxx> updateRole(XtJsxx xtJsxx){

        if(xtJsxx==null){
            return ResponseUtil.retErr("角色信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysRoleService.updateRole(xtJsxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 根据角色编号删除角色信息
     * @param jsbh
     * @return
     */
    @PostMapping("/delete_role")
    public ResponseEntity<Boolean> deleteRoleById(String jsbh){
        if(jsbh==null || jsbh==""){
            return ResponseUtil.retErr("角色编号不能为空");
        }

        try{
            if(this.sysRoleService.deleteRoleById(jsbh)){
                return ResponseUtil.retOK(true, "删除角色成功");
            }else{
                return ResponseUtil.retErr("删除角色错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }

    }
}
