package com.newoxen.springcloud.tbms.adminfeign.feign;

import com.github.pagehelper.PageInfo;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.ResponseEntity;
import com.newoxen.springcloud.tbms.adminfeign.fallback.SysUserFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Feign 接口
 * @Author gaowei
 */

@Component
@FeignClient(value = "user-service", fallback = SysUserFallBackService.class)
public interface SysUserFeignService {


    /**
     * 查询用户详细信息
     * @param czybh
     * @return
     */
    @RequestMapping("/query_userinfo")
    public ResponseEntity<XtCzyxx> queryUserInfo(@RequestParam("czybh") String czybh);

    /**
     * 分页查询用户列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_userlistpage_layui")
    public ResponseEntity<List<XtCzyxx>> queryUserListPageLayUI(
            @RequestParam("findtext")String findtext, @RequestParam("page")Integer page,
            @RequestParam("limit")Integer limit);

    /**
     * 分页查询用户列表
     * @param findtext
     * @return
     */
    @RequestMapping("/query_userlistpage")
    public PageInfo<XtCzyxx> queryUserListPage(@RequestParam("findtext")String findtext,
                                               @RequestParam("page_num")Integer page_num,
                                               @RequestParam("page_size")Integer page_size);


    /**
     * 保存用户详细信息
     * @param userInfo
     * @return
     */
    @PostMapping("/save_user")
    public ResponseEntity<String> saveUser(@RequestParam("userInfo")XtCzyxx userInfo);


    /**
     * 登录验证
     * @param dlzh
     * @param pass
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<XtCzyxx> loginUser(@RequestParam("dlzh")String dlzh, @RequestParam("pass")String pass);

    /**
     * 修改用户密码
     * @param dlzh
     * @param old_pass
     * @param new_pass
     * @return
     */
    @PostMapping("/change_password")
    public ResponseEntity<Boolean> changePassword(@RequestParam("dlzh")String dlzh,
                                                  @RequestParam("old_pass")String old_pass, @RequestParam("new_pass")String new_pass);


    /**
     * 删除用户
     * @param czybh
     * @return
     */
    @PostMapping("/delete_user")
    public ResponseEntity<Boolean> deleteUser(@RequestParam("czybh")String czybh);


}
