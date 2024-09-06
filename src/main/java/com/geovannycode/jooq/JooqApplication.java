package com.geovannycode.jooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.geovannycode.jooq.domain")
public class JooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(JooqApplication.class, args);
	}

}
