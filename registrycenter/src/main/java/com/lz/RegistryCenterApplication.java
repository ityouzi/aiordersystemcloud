package com.lz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistryCenterApplication.class,args);
		System.out.println("启动注册中心...");
	}
}
