package com.empapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpProducerApplication implements CommandLineRunner{

//	@Autowired
//	private EmployeeRepo employeeRepo;
//	
	public static void main(String[] args) {
		SpringApplication.run(EmpProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		employeeRepo.save(new Employee("raj", 4000));
//		employeeRepo.save(new Employee("ekta", 4000));
		
	}

}
