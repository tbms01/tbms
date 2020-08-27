package com.newoxen.springcloud.tbms.admin.service.impl;

import com.newoxen.springcloud.tbms.admin.service.VerifyCodeService;
import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;
import com.newoxen.springcloud.tbms.admin.util.ResponseUtil;
import com.newoxen.springcloud.tbms.admin.util.StringUtil;
import com.newoxen.springcloud.tbms.admin.util.VerifyCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service("VerifyCodeService")
public class VerifyCodeServiceImpl implements VerifyCodeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyCodeServiceImpl.class);

    public void outIMGStream(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        session.setAttribute("VerifyCode", verifyCode.toLowerCase());
        //生成图片
        int w = 200, h = 80;
        LOGGER.info("------------session:"+session.getAttribute("VerifyCode"));
        VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    public ResponseEntity<String> verifyCode(HttpServletRequest request) {
        boolean isRet = isVerifyCode(request);
        if (isRet) {
            return ResponseUtil.retOK("验证成功！");
        }
        return ResponseUtil.retErr("验证失败！");
    }

    public boolean isVerifyCode(HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("VerifyCode");
        String userVerifyCode = request.getParameter("VerifyCode");
        LOGGER.info("------------------verifyCode:"+verifyCode+"--userVerifyCode:"+userVerifyCode);
        if (!StringUtil.isNullOrSpace(verifyCode) && !StringUtil.isNullOrSpace(userVerifyCode) && verifyCode.toUpperCase().equals(userVerifyCode.toUpperCase())) {
            return true;
        }
        return false;
    }
}