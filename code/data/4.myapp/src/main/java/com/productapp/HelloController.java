package com.productapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("hello/{name}")
	public String hello(@PathVariable(name = "name")  String name) {
		return "we are learing spring boot your name is : "+ name ;
	}
}
