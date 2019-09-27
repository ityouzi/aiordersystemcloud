package com.lz;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户微服务模块
 */
@SpringBootApplication
@MapperScan("com.lz.repository")
@Slf4j
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class,args);
		log.info("用户微服务模块启动....");
	}
}
