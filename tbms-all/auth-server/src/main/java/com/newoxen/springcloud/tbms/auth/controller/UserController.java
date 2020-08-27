package com.newoxen.springcloud.tbms.auth.controller;


import com.newoxen.springcloud.tbms.auth.entity.XtCzyxx;
import com.newoxen.springcloud.tbms.auth.service.SysUserLoginService;
//import com.newoxen.springcloud.tbms.auth.util.ResponseEntity;
import com.newoxen.springcloud.tbms.auth.util.ResponseUtil;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import top.jfunc.common.utils.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 服务对象
     */
    @Autowired
    private SysUserLoginService sysUserService;

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = StrUtil.subAfter(header, "bearer", false);

        return Jwts.parser()
                .setSigningKey("tbms_key".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
    }


    /**
     * 登录验证
     * @param dlzh
     * @param pass
     * @return
     */
    @RequestMapping("/authlogin")
    public com.newoxen.springcloud.tbms.auth.util.ResponseEntity<XtCzyxx> loginUser(String dlzh, String pass){
        if(dlzh==null || dlzh==""){
            return ResponseUtil.retErr("登录账号不能为空");
        }
        if(pass==null || pass==""){
            return ResponseUtil.retErr("登录密码不能为空");
        }

        logger.debug("user login ...................【"+dlzh+"】");

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
     * 资源服务器提供的受保护接口
     * @param principal
     * @return
     */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
    }

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @GetMapping("/token")
    public Object getAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {

        return this.result(principal,parameters);
    }

    @PostMapping("/token")
    public Object postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {

        return this.result(principal,parameters);
    }

    public Object result(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        ResponseEntity<OAuth2AccessToken> accessToken = tokenEndpoint.getAccessToken(principal, parameters);
        OAuth2AccessToken body = accessToken.getBody();
        Map<String, Object> customMap = body.getAdditionalInformation();
        String value = body.getValue();
        OAuth2RefreshToken refreshToken = body.getRefreshToken();
        Set<String> scope = body.getScope();
        int expiresIn = body.getExpiresIn();
        customMap.put("token",value);
        customMap.put("scope",scope);
        customMap.put("expiresIn",expiresIn);
        customMap.put("refreshToken",refreshToken);
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","success");
        map.put("data",customMap);
        return map;
    }


}
