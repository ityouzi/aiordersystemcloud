package com.lz;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lz.repository")
@Slf4j
public class MenuApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class,args);
		log.info("菜单微服务启动...");
	}
}
