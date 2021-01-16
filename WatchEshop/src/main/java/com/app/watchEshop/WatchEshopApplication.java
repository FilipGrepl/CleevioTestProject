package com.app.watchEshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.app.database")
@EntityScan(basePackages = "com.app.database")
@ComponentScan(basePackages = {"com.app.database", "com.app.controllers", "com.app.services"})
public class WatchEshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(WatchEshopApplication.class, args);
	}
}
