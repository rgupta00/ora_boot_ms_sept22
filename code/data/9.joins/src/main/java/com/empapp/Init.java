package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.empapp.entity.Employee;
import com.empapp.entity.Parking;
import com.empapp.repo.EmployeeRepo;
import com.empapp.repo.ParkingRepo;
@Component
public class Init implements CommandLineRunner{

	@Autowired
	private ParkingRepo parkingRepo;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Parking parking1=new Parking("A34");
		Parking parking2=new Parking("Mw6");
		Parking parking3=new Parking("F40");
		
		
		Employee emp1=new Employee("ekta", 4000.00, parking1);
		Employee emp2=new Employee("keshav", 7000.00, parking2);
		Employee emp3=new Employee("gunika", 3400.00, parking3);
		
		parking1.setEmployee(emp1);
		parking2.setEmployee(emp2);
		parking3.setEmployee(emp3);
		
		empRepo.save(emp1);
		empRepo.save(emp2);
		empRepo.save(emp3);
		
		parkingRepo.save(parking1);
		parkingRepo.save(parking2);
		parkingRepo.save(parking3);

	}

}
