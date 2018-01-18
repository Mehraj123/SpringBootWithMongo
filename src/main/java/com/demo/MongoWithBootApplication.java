package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
// @EnableScheduling
// @PropertySource("file:config.properties")
// @PropertySource("#{systemEnvironment['LOCATION']}")
public class MongoWithBootApplication {

	/*
	 * @Value("#{systemEnvironment['LOCATION']}") private String location;
	 * 
	 * public void hi() { System.out.println("--- ENV " + location); }
	 */

	public static void main(String[] args) {
		// SpringApplication.run(MongoWithBootApplication.class,
		// args).getBean(MongoWithBootApplication.class).hi();;

		SpringApplication.run(MongoWithBootApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
