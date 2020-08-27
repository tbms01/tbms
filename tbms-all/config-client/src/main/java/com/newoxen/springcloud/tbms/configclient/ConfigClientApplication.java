package com.newoxen.springcloud.tbms.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
@RequestMapping("/app")
public class ConfigClientApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}



	@Value("${app.name}")
	private String _app_name;





	@GetMapping("name")
	public String GetAppName()
	{
		return _app_name;
	}


}
