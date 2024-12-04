package com.kallpacode.reactivemysql;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@OpenAPIDefinition(
		info = @Info(
				title = "Reactive MySQL API",
				version = "1.0",
				description = "API documentation for the Reactive MySQL application"
		)
)
public class ReactiveMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMysqlApplication.class, args);
	}
}