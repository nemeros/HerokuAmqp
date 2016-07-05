package com.conf;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.MessageMq;
import com.RabbitConfig;
import com.dao.MessageDao;

@EnableAutoConfiguration
@ComponentScan("com*")
@EnableRabbit
public class Application{

	@Autowired
	private MessageConverter messageConverter;
	
	@Autowired
	private MessageDao msgDao;
	
	public static final void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
	
	
	@RabbitListener(queues={RabbitConfig.helloWorldQueueName})
	public void onMessage(Message data){
		
		final MessageMq msg = (MessageMq)messageConverter.fromMessage(data);
		
		msgDao.saveMessage(msg);
	}
}