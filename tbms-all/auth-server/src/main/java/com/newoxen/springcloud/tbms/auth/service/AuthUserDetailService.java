package com.newoxen.springcloud.tbms.auth.service;

import com.newoxen.springcloud.tbms.auth.entity.SecurityUser;
import com.newoxen.springcloud.tbms.auth.entity.XtCzyxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 昆明鑫牛科技 (C) 2015
 * OAuth2 用户统一认证服务中心
 * @author gaowei
 */

@Service
public class AuthUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserLoginService sysUserLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        XtCzyxx user = sysUserLoginService.queryUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码错误1");
        }

        return new User(username,
                user.getDlmm(),
                true,
                true,
                true,
                true,
                getGrantedAuthority());
    }

    private List<GrantedAuthority> getGrantedAuthority(){
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return list;
    }
}