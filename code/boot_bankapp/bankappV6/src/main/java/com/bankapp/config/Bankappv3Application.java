package com.bankapp.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@SpringBootApplication
@ComponentScan({"com.bankapp"})
@EntityScan("com.bankapp.entities")
@EnableJpaRepositories("com.bankapp.repository")
public class Bankappv3Application implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(Bankappv3Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

     	accountService.addAccount(new Account("ravi", new BigDecimal(6000),"7733289990","delhi"));
		accountService.addAccount(new Account("sumit",  new BigDecimal(6000),"7733289980","banglore"));
		
		System.out.println("------------------");
		
	}

}
