package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private Logger logger=LoggerFactory.getLogger(MyController.class);
	@GetMapping("helloms4")
	public String hello() {
		logger.info("inside mycontroller ms4");
		return "hello from ms4";
	}
	

}
