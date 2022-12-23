package com.dk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGateWayApplication.class, args);
	}

}
