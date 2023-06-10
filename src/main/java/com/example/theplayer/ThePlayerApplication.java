package com.example.theplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ThePlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThePlayerApplication.class, args);
	}

}
