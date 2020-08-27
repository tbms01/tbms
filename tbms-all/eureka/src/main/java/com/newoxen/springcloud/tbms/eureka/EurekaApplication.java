package com.newoxen.springcloud.tbms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 昆明鑫牛科技 (C) 2015
 * 云南拓邦科技 TBMS项目
 * Eureka Server 服务注册中心服务
 */


@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

}
