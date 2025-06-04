package com.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.app")
//@EnableJpaRepositories(basePackages = "com.app.Database.Postgre")
//@EntityScan(basePackages = "com.app.Database.Postgre")
public class EmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApplication.class, args);
	}

}
