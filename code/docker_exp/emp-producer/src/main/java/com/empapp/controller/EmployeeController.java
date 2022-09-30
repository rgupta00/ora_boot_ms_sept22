package com.empapp.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.entity.Employee;
import com.empapp.exceptions.EmployeeNotFoundException;
import com.empapp.repo.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("employee/{id}")
	public Employee getById(@PathVariable int id) {
		return employeeRepo.findById(id).orElseThrow(EmployeeNotFoundException:: new);
	}
	@GetMapping("employee")
	public List<Employee> getAll(@PathVariable int id) {
		
		return employeeRepo.findAll();
	}
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		 employeeRepo.save(employee);
		 return employee;
	}
}
