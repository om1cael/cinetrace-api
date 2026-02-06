package com.cinetrace.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CineTraceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineTraceApiApplication.class, args);
	}

}
