package com.empapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class Employee {
	
	private int id;
	private String name;
	private double salary;
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	
}

