package com.wddfx.spcdemobase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.wddfx.*.dao"})
@SpringBootApplication
public class SpcdemoBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcdemoBaseApplication.class, args);
	}
}
