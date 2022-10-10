package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.example.demo.Controller", "com.example.demo.Model", "com.example.demo.Repository","com.example.demo.Repository.CrudRepository", "com.example.demo.Service" })

@EntityScan("com.example.demo.Model")
@EnableJpaRepositories("com.example.demo.Repository")

public class Reto3Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Ciclo3Application.class, args);
	}

}
