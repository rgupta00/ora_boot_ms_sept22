package com.bookapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.entity.Book;
import com.bookapp.repo.BookRepo;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

	@Autowired
	private BookRepo repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		repo.save(new Book("java is fun", new Date(), 300, 340));
//		repo.save(new Book("java is fun", new Date(), 300, 340));
	}

}
