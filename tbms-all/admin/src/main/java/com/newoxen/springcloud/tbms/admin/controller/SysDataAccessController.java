package com.newoxen.springcloud.tbms.admin.controller;


import com.newoxen.springcloud.tbms.admin.entity.XtSjqx;
import com.newoxen.springcloud.tbms.admin.service.SysDataAccessService;
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
@RequestMapping("/admin/date_access")
public class SysDataAccessController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysDataAccessController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysDataAccessService sysDataAccessService;

    /**
     * 查询一条数据权限详细信息
     * @param appid
     * @return
     */
    @RequestMapping("/query_dataaccess_info")
    public ResponseEntity<XtSjqx> queryDataAccessInfo(String appid){
        if(appid==null || appid==""){
            return ResponseUtil.retErr("编号不能为空");
        }

        try{
            return ResponseUtil.retOK(this.sysDataAccessService.queryDataAccessById(appid));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 查询多条数据权限详细信息
     * @return
     */
    @RequestMapping("/query_dataaccess_list_page")
    public List<XtSjqx> queryDataAccessList(int offset, int limit){
        if(offset<1){
            offset = 1; //默认开始页
        }
        if(limit<1){
            limit = 10; //默认每页大小
        }

        try{
            List<XtSjqx> list_dataAccess = this.sysDataAccessService.queryAllDataAccessByPage(offset,limit);
            return list_dataAccess;
        }catch (Exception ex){
            LOGGER.error("【API sys/date_access/query_dataAccessList_page错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 新增数据权限信息
     * @param xtSjqx
     * @return
     */
    @PostMapping("/insert_dataaccess")
    public ResponseEntity<XtSjqx> insertDataAccess(XtSjqx xtSjqx){

        if(xtSjqx==null){
            return ResponseUtil.retErr("信息不能为空");
        }

        try{
            return ResponseUtil.retOK( this.sysDataAccessService.insertDataAccess(xtSjqx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 修改数据权限信息
     * @param xtSjqx
     * @return
     */
    @PostMapping("/update_dataaccess")
    public ResponseEntity<XtSjqx> updateDataAccess(XtSjqx xtSjqx){

        if(xtSjqx==null){
            return ResponseUtil.retErr("信息不能为空");
        }

        try{
            return ResponseUtil.retOK( this.sysDataAccessService.updateDataAccess(xtSjqx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 根据数据权限编号删除数据权限信息
     * @param appid
     * @return
     */
    @PostMapping("/delete_dataaccess")
    public ResponseEntity<Boolean> deleteDataAccessById(String appid){
        if(appid==null || appid==""){
            return ResponseUtil.retErr("数据权限编号不能为空");
        }

        try{
            if(this.sysDataAccessService.deleteDataAccessById(appid)){
                return ResponseUtil.retOK(true, "删除数据权限成功");
            }else{
                return ResponseUtil.retErr("删除数据权限错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }

    }
}
