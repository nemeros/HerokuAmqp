package com.conf;

import java.nio.charset.StandardCharsets;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.RabbitConfig;

@EnableAutoConfiguration
@ComponentScan("com*")
@EnableRabbit
public class Application{

	@Autowired
	private MessageConverter messageConverter;
	
	
	public static final void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
	@RabbitListener(queues={RabbitConfig.helloWorldQueueName})
	public void onMessage(Message data){
		System.out.println(new String((byte[])messageConverter.fromMessage(data), StandardCharsets.UTF_8));
	}
}