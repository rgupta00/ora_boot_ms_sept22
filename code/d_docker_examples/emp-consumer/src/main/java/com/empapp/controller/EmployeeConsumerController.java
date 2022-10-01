package com.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.empapp.dto.Employee;

@RestController
public class EmployeeConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "employee-consumer")
	public String getEmployee() {
		Employee employee=restTemplate.getForObject("http://producer:8080/employees/1", Employee.class);
		return employee.toString();
	}
}

