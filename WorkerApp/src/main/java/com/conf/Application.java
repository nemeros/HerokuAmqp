package com.conf;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.RabbitConf;

@ComponentScan("com*")
@EnableAutoConfiguration
@EnableRabbit
@Configuration
public class Application{

	public static final void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
	@RabbitListener(queues=RabbitConf.helloQueueName)
	public void onMessage(String data){
		System.out.println(data);
	}
}