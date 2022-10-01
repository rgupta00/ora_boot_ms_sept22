package com.configserverclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class Hello {

	@Value("${spring.datasource.url: default value}")
	private String url;
	
	@GetMapping("/")
	public String sayHello() {
		return url;
	}
}