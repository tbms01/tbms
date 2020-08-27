package com.newoxen.springcloud.tbms.auth.config;

import com.newoxen.springcloud.tbms.auth.service.AuthUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 昆明鑫牛科技 (C) 2015
 * 云南拓邦科技 TBMS项目
 * OAuth2 用户统一认证服务中心
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    /**
     * 1:
     * 请求授权:
     * spring security 使用以下匹配器来匹配请求路劲：
     *      antMatchers:使用ant风格的路劲匹配
     *      regexMatchers:使用正则表达式匹配路劲
     * anyRequest:匹配所有请求路劲
     * 在匹配了请求路劲后，需要针对当前用户的信息对请求路劲进行安全处理。
     * 2:定制登录行为。
     *      formLogin()方法定制登录操作
     *      loginPage()方法定制登录页面访问地址
     *      defaultSuccessUrl()登录成功后转向的页面
     *      permitAll()
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/oauth/**", "/login/**", "/logout/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 配置用户名密码，这里采用内存方式，生产环境需要从数据库获取
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordSecEncoder().encode("123456"))
//                .roles("USER");
//    }
}