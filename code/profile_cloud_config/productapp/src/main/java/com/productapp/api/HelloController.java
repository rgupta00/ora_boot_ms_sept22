package com.productapp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${hello.message}")
	private String message;
	
	@GetMapping(path = "hello")
	public String profileHello() {
		return message;
	}
}
