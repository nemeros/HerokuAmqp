package com.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

	@RequestMapping(value="api/hello", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> sayHello(@RequestParam(required=false,name="name") String name){
		return new ResponseEntity<String>("Hello " + name + " from service", HttpStatus.OK);
	}
	

}
