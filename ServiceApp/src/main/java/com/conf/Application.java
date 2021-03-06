package com.conf;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan("com*")
@Configuration
@EnableRabbit
public class Application {

	public static final void main(String[] args){	
		SpringApplication.run(Application.class, args);
	}
}
