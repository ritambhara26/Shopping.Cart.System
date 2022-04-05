package com.shopping.DiscServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscServerApplication.class, args);
	}

}
