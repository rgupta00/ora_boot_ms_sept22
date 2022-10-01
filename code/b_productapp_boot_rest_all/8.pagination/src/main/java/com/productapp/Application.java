package com.productapp;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserting many products
		List<Product> list=IntStream.rangeClosed(1, 500)
				.mapToObj
				(i-> new Product("product "+i , new Random().nextInt(100), new Random().nextInt(5000)))
				.collect(Collectors.toList());
		productRepo.saveAll(list);
		System.out.println("-------------");
	}

}
