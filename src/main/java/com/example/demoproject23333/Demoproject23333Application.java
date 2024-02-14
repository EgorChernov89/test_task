package com.example.demoproject23333;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demoproject23333Application {

	public static void main(String[] args) {
		SpringApplication.run(Demoproject23333Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper( ){
  		return new ModelMapper();
	}
}
