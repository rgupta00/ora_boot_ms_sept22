package com.bookapp;
import java.util.*;
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
		repo.save(new Book("spring in action", new Date(), 300, 340));
		repo.save(new Book("rich dad poor dad", new Date(), 300, 340));
		getAllbooks();
	}

	private void getAllbooks() {
		System.out.println("getting all books");
		List<Book> books=repo.findAll();
		books.forEach(b-> System.out.println(b));
	}

}
