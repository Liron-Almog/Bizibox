package com.ex.homeTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner->{
			System.out.println("Hello world");
		};
	}
}
