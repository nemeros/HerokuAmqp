package com.conf;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.RabbitConfig;

@EnableAutoConfiguration
@ComponentScan("com*")
@EnableRabbit
public class Application{

	public static final void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
	@RabbitListener(queues={RabbitConfig.helloWorldQueueName})
	public void onMessage(String data){
		System.out.println(data);
	}
}