package com.bankapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@Component
public class DbInit implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	
	@Override
	public void run(String... args) throws Exception {
		
		accountService.addAccount(new Account("amit", new BigDecimal(1000), "54545404555", "amit@gmail.com"));
		accountService.addAccount(new Account("sumit", new BigDecimal(1000), "54545454555", "sumit@gmail.com"));
	}

}
