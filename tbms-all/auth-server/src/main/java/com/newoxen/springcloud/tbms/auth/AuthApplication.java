package com.newoxen.springcloud.tbms.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 昆明鑫牛科技 (C) 2015
 * 云南拓邦科技 TBMS项目
 * OAuth2 用户统一认证服务中心
 */



@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.newoxen.springcloud.tbms.auth.dao")
@EnableEurekaClient
public class AuthApplication {


	public static void main(String[] args) {

		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		System.out.println("DEAULT PASSWD: 123456=>"+bpe.encode("123456"));


		SpringApplication.run(AuthApplication.class,args);
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
