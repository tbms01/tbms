package com.newoxen.springcloud.tbms.admin.controller;


import com.newoxen.springcloud.tbms.admin.entity.XtGnxx;
import com.newoxen.springcloud.tbms.admin.service.SysFuncService;
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
@RequestMapping("/admin/func")
public class SysFuncController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysFuncController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysFuncService sysFuncService;

    /**
     * 根据ID查询单个功能详细信息
     * @param appid
     * @return
     */
    @RequestMapping("/query_func_info")
    public ResponseEntity<XtGnxx> queryUserInfo(String appid){
        if(appid==null || appid==""){
            return ResponseUtil.retErr("功能编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysFuncService.queryFuncById(appid));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 查询多条功能详细信息
     * @return
     */
    @RequestMapping("/query_func_list_page")
    public List<XtGnxx> queryRoleList(int offset, int limit){
        if(offset<1){
            offset = 1; //默认开始页
        }
        if(limit<1){
            limit = 10; //默认每页大小
        }

        try{
            List<XtGnxx> list_func = sysFuncService.queryAllFuncByPage(offset,limit);
            return list_func;
        }catch (Exception ex){
            LOGGER.error("【API sys/role/query_funcList_page错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 新增功能信息
     * @param xtGnxx
     * @return
     */
    @PostMapping("/insert_func")
    public ResponseEntity<XtGnxx> insertRole(XtGnxx xtGnxx){

        if(xtGnxx==null){
            return ResponseUtil.retErr("功能信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysFuncService.insertFunc(xtGnxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 修改角色信息
     * @param xtGnxx
     * @return
     */
    @PostMapping("/update_func")
    public ResponseEntity<XtGnxx> updateRole(XtGnxx xtGnxx){

        if(xtGnxx==null){
            return ResponseUtil.retErr("功能信息不能为空");
        }
        try{
            return ResponseUtil.retOK( sysFuncService.updateFunc(xtGnxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 根据角色编号删除角色信息
     * @param appid
     * @return
     */
    @PostMapping("/delete_func")
    public ResponseEntity<Boolean> deleteFuncById(String appid){
        if(appid==null || appid==""){
            return ResponseUtil.retErr("功能编号不能为空");
        }

        try{
            if(this.sysFuncService.deleteFuncById(appid)){
                return ResponseUtil.retOK(true, "删除功能信息成功");
            }else{
                return ResponseUtil.retErr("删除功能信息错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }

    }
}
