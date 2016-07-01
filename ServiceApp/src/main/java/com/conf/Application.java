package com.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan("com*")
@Configuration
public class Application {

	public static final void main(String[] args){	
		SpringApplication.run(Application.class, args);
	}
}
