package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${hello.message}")
	private String message;
	
	@Value("${hello.message2}")
	private String message2;
	@Autowired
	private DbConfig config;
//	
	@GetMapping(path = "hello")
	public String hello() {
		System.out.println(config.getUsername());
		System.out.println(config.getPassword());
		System.out.println(config.getDbtype());
		return message+ " : "+ message2;
	}
}
