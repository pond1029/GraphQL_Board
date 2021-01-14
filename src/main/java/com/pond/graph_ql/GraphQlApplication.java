package com.pond.graph_ql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class GraphQlApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}
	
}
