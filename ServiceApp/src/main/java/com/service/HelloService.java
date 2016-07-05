package com.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MessageMq;
import com.dao.MessageDao;

@RestController
public class HelloService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private MessageDao msgDao;

	@RequestMapping(value="api/hello", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<MessageMq>> sayHello(@RequestParam(required=false,name="name") String name){
		return new ResponseEntity<List<MessageMq>>(msgDao.getAllMessage(), HttpStatus.OK);
	}
	

	@RequestMapping(value="api/hello", method=RequestMethod.PUT, consumes="application/json")	
	@ResponseStatus(value=HttpStatus.OK)
	public void pushMessage(@RequestBody(required=true) MessageMq message){
		System.out.println(message.toString());
		rabbitTemplate.convertAndSend(message);
	}
}
