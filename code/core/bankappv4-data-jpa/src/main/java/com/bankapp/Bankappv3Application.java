package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@SpringBootApplication
public class Bankappv3Application implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(Bankappv3Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		accountService.addAccount(new Account("ravi", 6000));
		accountService.addAccount(new Account("sumit", 6000));
		
		System.out.println("------------------");
		
	}

}
