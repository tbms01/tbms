package com.newoxen.springcloud.tbms.adminfeign.controller;

import com.github.pagehelper.PageInfo;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.ResponseEntity;
import com.newoxen.springcloud.tbms.adminfeign.feign.SysUserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 系统用户Feign控制层
 *
 * @author gaowei
 * @since 2020-04-29 13:44:19
 */

@RestController
@RequestMapping("/admin/feign")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class SysUserFeignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserFeignController.class);

    /**
     * 服务对象
     */
    @Autowired
    private SysUserFeignService sysUserFeignService;


    /**
     * 查询用户详细信息
     * @param czybh
     * @return
     */
    @RequestMapping("/query_userinfo")
    public ResponseEntity<XtCzyxx> queryUserInfo(@RequestParam("czybh") String czybh){
        return sysUserFeignService.queryUserInfo(czybh);
    }


    /**
     * 分页查询用户列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_userlistpage_layui")
    public ResponseEntity<List<XtCzyxx>> queryUserListPageLayUI(@RequestParam("findtext")String findtext,@RequestParam("page") Integer page, @RequestParam("limit")Integer limit){
        return sysUserFeignService.queryUserListPageLayUI(findtext, page, limit);
    }

    /**
     * 分页查询用户列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_userlistpage")
    public PageInfo<XtCzyxx> queryUserListPage(@RequestParam("findtext")String findtext, @RequestParam("page_num")Integer page_num, @RequestParam("page_size")Integer page_size){
        return sysUserFeignService.queryUserListPage(findtext, page_num, page_size);
    }


    /**
     * 保存用户详细信息
     * @param userInfo
     * @return
     */
    @PostMapping("/save_user")
    public ResponseEntity<String> saveUser(@RequestParam("userInfo")XtCzyxx userInfo){
        return sysUserFeignService.saveUser(userInfo);
    }


    /**
     * 登录验证
     * @param dlzh
     * @param pass
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<XtCzyxx> loginUser(@RequestParam("dlzh")String dlzh, @RequestParam("pass")String pass){
        return sysUserFeignService.loginUser(dlzh, pass);
    }

    /**
     * 修改用户密码
     * @param dlzh
     * @param old_pass
     * @param new_pass
     * @return
     */
    @PostMapping("/change_password")
    public ResponseEntity<Boolean> changePassword(@RequestParam("dlzh")String dlzh, @RequestParam("old_pass")String old_pass, @RequestParam("new_pass")String new_pass){
        return sysUserFeignService.changePassword(dlzh, old_pass, new_pass);
    }


    /**
     * 删除用户
     * @param czybh
     * @return
     */
    @PostMapping("/delete_user")
    public ResponseEntity<Boolean> deleteUser(@RequestParam("czybh")String czybh)
    {
        return sysUserFeignService.deleteUser(czybh);
    }


}