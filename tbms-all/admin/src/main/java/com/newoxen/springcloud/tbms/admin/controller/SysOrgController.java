package com.newoxen.springcloud.tbms.admin.controller;

import com.newoxen.springcloud.tbms.admin.entity.*;
import com.newoxen.springcloud.tbms.admin.service.SysOrgService;
import com.newoxen.springcloud.tbms.admin.service.SysPositionService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 岗位接口
 *
 * @author zm
 */

@RestController
@RequestMapping("/admin/org")
public class SysOrgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysOrgController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysOrgService sysOrgService;

    /**
     * 查询岗位详细信息
     * @param zzbm
     * @return
     */
    @RequestMapping("/query_org_info")
    public ResponseEntity<XtZzxx> queryOrgInfo(String zzbm){
        if(zzbm==null || zzbm==""){
            return ResponseUtil.retErr("组织编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysOrgService.queryById(zzbm));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 查询岗位详细信息
     * @return
     */
    @RequestMapping("/query_org_list_page")
    public ResponseEntity<List<XtZzxx>> queryPositionList(int page, int limit){
        if(page<1){
            page = 1; //默认开始页
        }
        if(limit<1){
            limit = 10; //默认每页大小
        }
        int offset = (page-1)*limit;
        try{
            ResponseEntity<List<XtZzxx>> ret_data = new ResponseEntity<>();
            List<XtZzxx> list = sysOrgService.queryAllByLimit( offset, limit);

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/role/query_roleList_page错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 查询所有岗位编号
     * @return
     */
    @RequestMapping("/query_org_all")
    public ResponseEntity<List<XtZzxx>> queryAllOrg(){
        try{
            ResponseEntity<List<XtZzxx>> ret_data = new ResponseEntity<>();
            List<XtZzxx> list = sysOrgService.queryAll();
            System.out.println(list);
            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/position/query_position_num错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 新增岗位信息
     * @param xtZzxx
     * @return
     */
    @PostMapping("/insert_org")
    public ResponseEntity<XtZzxx> insertRole(XtZzxx xtZzxx){

        if(xtZzxx==null){
            return ResponseUtil.retErr("组织信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysOrgService.insert(xtZzxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 修改岗位信息
     * @param xtZzxx
     * @return
     */
    @PostMapping("/update_org")
    public ResponseEntity<XtZzxx> updateRole(XtZzxx xtZzxx){

        if(xtZzxx==null){
            return ResponseUtil.retErr("组织信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysOrgService.update(xtZzxx));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 根据岗位编号删除岗位信息
     * @param zzbm
     * @return
     */
    @PostMapping("/delete_org")
    public ResponseEntity<Boolean> deletePositionById(String zzbm){
        if(zzbm==null || zzbm==""){
            return ResponseUtil.retErr("组织编号不能为空");
        }

        try{
            if(this.sysOrgService.deleteById(zzbm)){
                return ResponseUtil.retOK(true, "删除组织成功");
            }else{
                return ResponseUtil.retErr("删除组织错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }

    }

    /**
     * 分页查询组织列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_orglistpage_layui")
    public ResponseEntity<List<XtZzxx>> queryOrgListPageLayUI(String findtext, Integer page, Integer limit){
        if(page == null || page<1){
            page = 1; //默认开始页
        }
        if(limit ==null || limit<1){
            limit = 10; //默认每页大小
        }

        int offset = (page-1)*limit;

        try{
            ResponseEntity<List<XtZzxx>> ret_data = new ResponseEntity<>();
            List<XtZzxx> list_org = sysOrgService.queryAllUserByFilter(findtext, offset, limit);
            Integer list_count = sysOrgService.queryAllByFilterCount(findtext, offset, limit);

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_org);
            ret_data.setCount(list_count);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API admin/org/query_orglistpage_layui】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 查询组织树
     * @return
     */
    @RequestMapping("/query_orgtree")
    public ResponseEntity<List<LayUITree>> queryOrgTree(){

        try{
            ResponseEntity<List<LayUITree>> ret_data = new ResponseEntity<>();

            List<LayUITree> list_org = sysOrgService.queryAllByFather("-1");

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_org);
            ret_data.setCount(0);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API admin/org/query_orgtree】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 分页查询组织列表
     * @param sjzzbm
     * @return
     */
    @RequestMapping("/query_orglistpagebyfather_layui")
    public ResponseEntity<List<XtZzxxExtend>> queryOrgListPageByFatherLayUI(String sjzzbm, Integer page, Integer limit){
        if(page == null || page<1){
            page = 1; //默认开始页
        }
        if(limit ==null || limit<1){
            limit = 10; //默认每页大小
        }

        int offset = (page-1)*limit;

        try{
            ResponseEntity<List<XtZzxxExtend>> ret_data = new ResponseEntity<>();
            List<XtZzxxExtend> list_org = sysOrgService.queryAllByFatherPager(sjzzbm, offset, limit);
            Integer list_count = sysOrgService.queryAllByFatherPagerCount(sjzzbm, offset, limit);

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_org);
            ret_data.setCount(list_count);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API admin/org/query_orglistpagebyfather_layui】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 保存用户详细信息
     * @param xtZzxx
     * @return
     */
    @PostMapping("/save_org")
    public ResponseEntity<String> saveOrg(XtZzxx xtZzxx){

        if(xtZzxx==null){
            return ResponseUtil.retErr("组织信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysOrgService.saveOrg(xtZzxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }
}
