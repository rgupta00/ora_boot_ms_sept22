package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(MyController.class);
	@GetMapping("helloms1")
	public String hello() {
		logger.info("inside mycontroller ms1");
		String value =restTemplate.getForObject("http://localhost:8082/helloms2", String.class);
		logger.info("value return from ms2"+value);
		return "hello from ms1";
	}
}
