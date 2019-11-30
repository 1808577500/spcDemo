package com.wddfx.spcdemoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpcdemoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcdemoServerApplication.class, args);
	}
}
