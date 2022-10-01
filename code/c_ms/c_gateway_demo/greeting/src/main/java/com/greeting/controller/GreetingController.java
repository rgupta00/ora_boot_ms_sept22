package com.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
	@GetMapping("/greeting")
	public String getMessage(@RequestHeader("first-request") String header) {
		System.out.println("---------------------------");
		System.out.println(header);
		return "Welcome to greeting service";
	}
}
