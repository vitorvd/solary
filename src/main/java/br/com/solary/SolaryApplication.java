package br.com.solary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SolaryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SolaryApplication.class, args);
	}
	
}
