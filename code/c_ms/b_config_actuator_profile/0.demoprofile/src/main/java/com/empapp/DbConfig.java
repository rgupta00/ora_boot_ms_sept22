package com.empapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "db")
public class DbConfig {

	private String username;
	private String password;
	private String dbtype;
}
