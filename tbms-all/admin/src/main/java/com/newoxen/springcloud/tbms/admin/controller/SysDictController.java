package com.newoxen.springcloud.tbms.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newoxen.springcloud.tbms.admin.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.admin.entity.XtDm;
import com.newoxen.springcloud.tbms.admin.service.SysDmService;
import com.newoxen.springcloud.tbms.admin.service.SysUserService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字典管理类
 * @author gaowei
 */

@RestController
@RequestMapping("/admin")
public class SysDictController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysDictController.class);

    @Autowired
    private SysDmService sysDmService;

    /**
     * 分页查询字典列表
     * @param findtext
     * @return
     */
    @RequestMapping("/dict/query_list_page")
    public ResponseEntity<List<XtDm>> queryDictListPage(String findtext, Integer page, Integer limit){
        if(page == null || page<1){
            page = 1; //默认开始页
        }
        if(limit ==null || limit<1){
            limit = 10; //默认每页大小
        }

        int offset = (page-1)*limit;

        try{
            ResponseEntity<List<XtDm>> ret_data = new ResponseEntity<>();
            List<XtDm> list_data = sysDmService.queryAllUserByFilter(findtext, offset, limit);
            Integer list_count = sysDmService.queryAllByFilterCount(findtext);

            ret_data.setCode(0);
            ret_data.setMsg("操作成功！");
            ret_data.setData(list_data);
            ret_data.setCount(list_count);
            return ret_data;
        }catch (Exception ex){
            LOGGER.error("【API admin/dict/query_list_page错误】："+ex.getMessage());
            return null;
        }
    }
}
