package com.productapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.productapp.entity.Product;
import com.productapp.entity.UserEntity;
import com.productapp.service.ProductService;
import com.productapp.service.UserService;
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new Product("laptop", new BigDecimal(100000),"raj"));
		productService.addProduct(new Product("laptop mouse", new BigDecimal(1000),"ekta"));
		
		userService.addUserEntity(new UserEntity("raj", "raj123",Arrays.asList("ROLE_ADMIN","ROLE_MGR")));
		userService.addUserEntity(new UserEntity("ekta", "ekta123",Arrays.asList("ROLE_MGR")) );
		
		System.out.println("------------------------------------------------");
	}

}
