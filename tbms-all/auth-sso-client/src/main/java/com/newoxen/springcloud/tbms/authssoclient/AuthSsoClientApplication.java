package com.newoxen.springcloud.tbms.authssoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableOAuth2Sso
@SpringBootApplication
@EnableEurekaClient
public class AuthSsoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSsoClientApplication.class, args);
	}

}
