package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct(new Product("laptop", new BigDecimal(100000)));
		productService.addProduct(new Product("laptop mouse", new BigDecimal(1000)));
		
	}

}
