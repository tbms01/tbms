package com.newoxen.springcloud.tbms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心Git版本
 * gaowei@2020
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {

		//演示项目从git获取全局项目参数配置
		GetGlobalConfigFromGitDemo();

		SpringApplication.run(ConfigApplication.class, args);


	}

	//演示项目从git获取全局项目参数配置
	private static void GetGlobalConfigFromGitDemo(){

	}



}
