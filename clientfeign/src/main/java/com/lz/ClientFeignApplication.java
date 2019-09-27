package com.lz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@ServletComponentScan
@Slf4j
public class ClientFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientFeignApplication.class,args);
		log.info("消费者客户端启动...");
	}

}
