package com.bankapp.controller;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

public class Main {

	
	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext vs AnnotationConfigApplicationContext
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=ctx.getBean("accountService", AccountService.class);
		
		List<Account> accounts=accountService.getAll();
		accounts.forEach(acc-> System.out.println(acc));
		
     	accountService.transfer(1, 2, 10);
		System.out.println("------------------------------");
		accounts=accountService.getAll();
		accounts.forEach(acc-> System.out.println(acc));
//		
		ctx.close();
		
	}
}





