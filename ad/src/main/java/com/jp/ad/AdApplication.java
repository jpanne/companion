package com.jp.ad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class AdApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AdApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AdApplication.class, args);
	}

}
