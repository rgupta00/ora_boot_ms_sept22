package com.bankapp;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Bankappv3Application implements CommandLineRunner {

	// i want to check if spring boot have conf all the infra bean ?

	@Autowired
	private EntityManager em;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Bankappv3Application.class, args);

		// spring boot dep on what u select config lots of bean :)

		String[] beans = ctx.getBeanDefinitionNames();
//		for (String bean : beans) {
//			System.out.println(bean);
//		}
	}

	@Override
	public void run(String... args) throws Exception {
		if(em!=null) {
			System.out.println("em is configured done...");
		}
		
		if(jdbcTemplate!=null) {
			System.out.println("jdbcTemplate is configured done...");
		}
		
	}

}




