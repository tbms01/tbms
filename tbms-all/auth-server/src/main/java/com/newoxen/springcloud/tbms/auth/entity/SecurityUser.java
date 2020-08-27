package com.newoxen.springcloud.tbms.auth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.jfunc.common.utils.StrUtil;

import java.util.Collection;

/**
 * Spring Security UserDetails实现
 * @author gaowei
 * 修改用户ID类型Long为字符串
 */


public class SecurityUser implements UserDetails {
    private static final long serialVersionUID = 4872628781561412463L;

    private static final String ENABLE = "ENABLE";

    private Collection<GrantedAuthority> authorities;

    private String userId;

    private String nickName;

    private String loginName;

    private String loginPwd;

    private String status;

    private String groupId;

    private String groupName;

    public SecurityUser(String userId, String loginName, String loginPwd, String nickName, String groupId, String groupName) {
        this.setUserId(userId);
        this.setLoginName(loginName);
        this.setLoginPwd(loginPwd);
        this.setNickName(nickName);
        this.setGroupId(groupId);
        this.setGroupName(groupName);
    }

    public SecurityUser(String userId, String loginName, String loginPwd, String nickName, String groupId, String groupName, String status, Collection<GrantedAuthority> grantedAuthorities) {
        this.setUserId(userId);
        this.setLoginName(loginName);
        this.setLoginPwd(loginPwd);
        this.setNickName(nickName);
        this.setGroupId(groupId);
        this.setGroupName(groupName);
        this.setStatus(status);
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.getLoginPwd();
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return StrUtil.equals(this.status, ENABLE);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
