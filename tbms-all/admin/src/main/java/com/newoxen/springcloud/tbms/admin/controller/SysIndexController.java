package com.newoxen.springcloud.tbms.admin.controller;


import com.newoxen.springcloud.tbms.admin.service.VerifyCodeService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class SysIndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysIndexController.class);

    @Autowired
    private VerifyCodeService verifyCodeService; //图片验证码服务

    /**
     * Index显示
     */
    @RequestMapping("/")
    public ResponseEntity<String> index(){
        try{
            return ResponseUtil.retOK("Admin微服务示例 by newoxen.com");
        }catch (Exception ex){
            return ResponseUtil.retErr("API错误："+ex.getMessage());
        }
    }

    /**
     * 生成图片验证码
     * @throws IOException
     */
    @GetMapping(value = "getVcodeImage")
    public void getVerifyCodeIMG(HttpServletRequest request, HttpServletResponse response) throws IOException {

        LOGGER.info("getVcodeImage......");
        verifyCodeService.outIMGStream(request, response);
    }

    /**
     * 图片验证码校验
     * @return
     * @throws IOException
     */
    @GetMapping(value = "verifyCode")
    public ResponseEntity<String> verifyCode(HttpServletRequest request) throws IOException {
        return verifyCodeService.verifyCode(request);
    }
}
