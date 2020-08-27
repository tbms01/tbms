package com.newoxen.springcloud.tbms.adminfeign.feign;

import com.newoxen.springcloud.tbms.adminfeign.entity.XtGnxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtGwxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.XtJsxx;
import com.newoxen.springcloud.tbms.adminfeign.entity.ResponseEntity;
import com.newoxen.springcloud.tbms.adminfeign.fallback.SysUserPermissionFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign 接口
 * @Author gaowei
 */

@Component
@FeignClient(value = "permission-service", fallback = SysUserPermissionFallBackService.class)
public interface SysUserPermissionFeignService {

    /**
     * 查询用户的岗位信息
     * @param gwbh 岗位编号
     * @return
     */
    @RequestMapping("query_position")
    public ResponseEntity<XtGwxx> queryPositionByUser(String gwbh);

    /**
     * 查询一个岗位对应角色
     * @param gwbh
     * @return
     */
    @RequestMapping("query_roles")
    public ResponseEntity<List<XtJsxx>> queryAllRolesByPosition(String gwbh);

    /**
     * 查询一个岗位对应功能
     * @param gwbh
     * @return
     */
    @RequestMapping("query_accessfuncs")
    public ResponseEntity<List<XtGnxx>> queryAllFuncsByPosition(String gwbh);


    /**
     * 删除一个角色对应权限
     * @param jsbh
     * @return
     */
    @RequestMapping("remove_rolefuncs")
    public ResponseEntity<Boolean> removeRoleFuncs(String jsbh);

    /**
     * 添加权限
     * @param jsbh
     * @param gnbh
     * @return
     */
    @RequestMapping("add_accessfuncs")
    public ResponseEntity<Boolean> addRoleFunc(@RequestParam("jsbh")String jsbh,
                                               @RequestParam("gnbh")String gnbh);
}
