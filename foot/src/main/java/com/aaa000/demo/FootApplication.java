package com.aaa000.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class FootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootApplication.class, args);
	}

}
