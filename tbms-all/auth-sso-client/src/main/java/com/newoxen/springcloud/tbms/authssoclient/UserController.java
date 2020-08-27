package com.newoxen.springcloud.tbms.authssoclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取OAuth2认证
     * @param authentication
     * @return
     */
    @GetMapping("/getCurrentUser")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object get(Authentication authentication) {
        return authentication;
    }

    /**
     * 做验证
     * @param user
     * @return
     */
    @RequestMapping("/user")
    public Principal user(Principal user) {
        logger.info("++++++++++++++++++++++做验证++++++++++++++++++++++++++++++");
        return user;
    }

}