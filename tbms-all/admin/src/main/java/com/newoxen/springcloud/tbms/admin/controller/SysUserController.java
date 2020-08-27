package com.newoxen.springcloud.tbms.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newoxen.springcloud.tbms.admin.entity.*;
import com.newoxen.springcloud.tbms.admin.service.SysUserService;
import com.newoxen.springcloud.tbms.admin.util.*;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作员信息(XtCzyxx)表控制层
 *
 * @author gaowei
 * @since 2020-04-29 13:44:19
 */
@Api("系统用户API")
@RestController
@RequestMapping("/admin")
public class SysUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysUserService sysUserService;


    /**
     * 查询用户详细信息
     * @param czybh
     * @return
     */
    @ApiOperation(value="查询用户信息", notes = "按照操作员编号查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "czybh",value="操作员编号", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code=0/200,message="用户信息"),
            @ApiResponse(code=502,message="发生异常"),
            @ApiResponse(code=501,message="参数出错")
    })
    @RequestMapping("/query_userinfo")
    public ResponseEntity<XtCzyxx> queryUserInfo(String czybh){
        if(czybh==null || czybh==""){
            return ResponseUtil.retErr("操作员编号不能为空");
        }

        try{
            return ResponseUtil.retOK(sysUserService.queryUserById(czybh));
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }


    /**
     * 分页查询用户列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_userlistpage_layui")
    public ResponseEntity<List<XtCzyxx>> queryUserListPageLayUI(String findtext, Integer page, Integer limit){
        if(page == null || page<1){
            page = 1; //默认开始页
        }
        if(limit ==null || limit<1){
            limit = 10; //默认每页大小
        }

        int offset = (page-1)*limit;

        try{
            ResponseEntity<List<XtCzyxx>> ret_data = new ResponseEntity<>();
            List<XtCzyxx> list_user = sysUserService.queryAllUserByFilter(findtext, offset, limit);
            Integer list_count = sysUserService.queryAllByFilterCount(findtext);

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_user);
            ret_data.setCount(list_count);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API sys/user/query_userList_page错误】："+ex.getMessage());
            return null;
        }
    }

    /**
     * 分页查询用户列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_userlistpage")
    public PageInfo<XtCzyxx> queryUserListPage(String findtext, Integer page_num, Integer page_size){
        if(page_num == null || page_num<1){
            page_num = 1; //默认开始页
        }
        if(page_size ==null || page_size<1){
            page_size = 10; //默认每页大小
        }
        int offset = (page_num-1)*page_size;

        try{
            PageHelper.startPage(page_num, page_size);
            List<XtCzyxx> list_user = sysUserService.queryAllUserByFilter(findtext, offset, page_size);
            PageInfo<XtCzyxx> pageInfo = new PageInfo<>(list_user);
            return pageInfo;
        }catch (Exception ex){
            LOGGER.error("【API sys/user/query_userList_page错误】："+ex.getMessage());
            return null;
        }
    }


    /**
     * 保存用户详细信息
     * @param userInfo
     * @return
     */
    @PostMapping("/save_user")
    public ResponseEntity<String> saveUser(XtCzyxx userInfo){

        if(userInfo==null){
            return ResponseUtil.retErr("操作员信息不能为空");
        }

        try{
            return ResponseUtil.retOK( sysUserService.saveUser(userInfo) );
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }


    /**
     * 登录验证
     * @param dlzh
     * @param pass
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<XtCzyxx> loginUser(String dlzh, String pass){
        if(dlzh==null || dlzh==""){
            return ResponseUtil.retErr("登录账号不能为空");
        }
        if(pass==null || pass==""){
            return ResponseUtil.retErr("登录密码不能为空");
        }

        LOGGER.debug("user login ...................【"+dlzh+"】");

        try{
            XtCzyxx loginUser = sysUserService.loginUser(dlzh, pass);
            if(loginUser!=null){
                return ResponseUtil.retOK(loginUser);
            }else{
                return ResponseUtil.retErr("用户名或密码错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 修改用户密码
     * @param dlzh
     * @param old_pass
     * @param new_pass
     * @return
     */
    @PostMapping("/change_password")
    public ResponseEntity<Boolean> changePassword(String dlzh, String old_pass, String new_pass){
        if(dlzh==null || dlzh==""){
            return ResponseUtil.retErr("登录账号不能为空");
        }
        if(old_pass==null || old_pass==""){
            return ResponseUtil.retErr("旧密码不能为空");
        }
        if(new_pass==null || new_pass==""){
            return ResponseUtil.retErr("新密码不能为空");
        }

        try{
            if(this.sysUserService.changePassword(dlzh, old_pass, new_pass)){
                return ResponseUtil.retOK(true, "密码修改成功");
            }else{
                return ResponseUtil.retErr("用户名或密码错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }


    /**
     * 删除用户
     * @param czybh
     * @return
     */
    @PostMapping("/delete_user")
    public ResponseEntity<Boolean> deleteUser(String czybh)
    {
        if(czybh==null || czybh==""){
            return ResponseUtil.retErr("操作员编号不能为空");
        }

        try{
            if(this.sysUserService.deleteUserById(czybh)){
                return ResponseUtil.retOK(true, "删除用户成功");
            }else{
                return ResponseUtil.retErr("删除用户错误");
            }

        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

}