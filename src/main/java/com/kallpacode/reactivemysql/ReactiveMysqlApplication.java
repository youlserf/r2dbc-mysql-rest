package com.kallpacode.reactivemysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class ReactiveMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMysqlApplication.class, args);
	}
}
