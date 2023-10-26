package com.javaproject.busapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class BusapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusapiApplication.class, args);
	}

}
