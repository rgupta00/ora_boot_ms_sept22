package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private RestTemplate template;

	@GetMapping("/accessapi")
	public String invokeGreetingService() {
		return template.getForObject("http://localhost:8181/greet/greeting", String.class);
	}

}