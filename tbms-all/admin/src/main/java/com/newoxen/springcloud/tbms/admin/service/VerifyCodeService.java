package com.newoxen.springcloud.tbms.admin.service;

import com.newoxen.springcloud.tbms.admin.util.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码服务
 */

public interface VerifyCodeService {

    public void outIMGStream(HttpServletRequest request, HttpServletResponse response) throws IOException;

    public ResponseEntity<String> verifyCode(HttpServletRequest request);

    public boolean isVerifyCode(HttpServletRequest request);
}
