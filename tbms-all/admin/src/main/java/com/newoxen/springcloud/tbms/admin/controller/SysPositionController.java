package com.newoxen.springcloud.tbms.admin.controller;

import com.newoxen.springcloud.tbms.admin.entity.XtGwxx;
import com.newoxen.springcloud.tbms.admin.service.SysPositionService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 岗位接口
 *
 * @author zm
 */

@RestController
@RequestMapping("/admin/position")
public class SysPositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysPositionController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysPositionService sysPositionService;

    /**
     * 查询岗位详细信息
     * @param gwbh
     * @return
     */
    @RequestMapping("/query_position_info")
    public ResponseEntity<XtGwxx> queryUserInfo(String gwbh){
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
     * 查询岗位详细信息
     * @return
     */
    @RequestMapping("/query_position_list_page")
    public ResponseEntity<List<XtGwxx>> queryPositionList(String findtext,int page, int limit){
        if(page<1){
            page = 1; //默认开始页
        }
        if(limit<1){
            limit = 10; //默认每页大小
        }
        int offset = (page-1)*limit;
        try{
            ResponseEntity<List<XtGwxx>> ret_data = new ResponseEntity<>();
            List<XtGwxx> list = sysPositionService.queryAllPositionByPage( offset, limit);
            Integer count = sysPositionService.queryCount(findtext);

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list);
            ret_data.setCount(count);
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
    @RequestMapping("/query_position_id")
    public ResponseEntity<List<XtGwxx>> queryPositionNum(){
        try{
            ResponseEntity<List<XtGwxx>> ret_data = new ResponseEntity<>();
            List<XtGwxx> list = sysPositionService.queryAllPositionId();
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
     * @param xtGwxx
     * @return
     */
    @PostMapping("/insert_position")
    public ResponseEntity<XtGwxx> insertRole(XtGwxx xtGwxx){

        if(xtGwxx==null){
            return ResponseUtil.retErr("岗位信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysPositionService.insertPosition(xtGwxx) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 修改岗位信息
     * @param xtGwxx
     * @return
     */
    @PostMapping("/update_position")
    public ResponseEntity<XtGwxx> updateRole(XtGwxx xtGwxx){

        if(xtGwxx==null){
            return ResponseUtil.retErr("岗位信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysPositionService.updatePosition(xtGwxx));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 根据岗位编号删除岗位信息
     * @param gwbh
     * @return
     */
    @PostMapping("/delete_position")
    public ResponseEntity<Boolean> deletePositionById(String gwbh){
        if(gwbh==null || gwbh==""){
            return ResponseUtil.retErr("岗位编号不能为空");
        }

        try{
            if(this.sysPositionService.deletePositionById(gwbh)){
                return ResponseUtil.retOK(true, "删除岗位成功");
            }else{
                return ResponseUtil.retErr("删除岗位错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }

    }


}
