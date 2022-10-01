package com.empapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parking_table")
@Data
@NoArgsConstructor
public class Parking {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String loc;

	@JoinColumn(name = "eid_fk")
	@OneToOne
	private Employee employee;

	public Parking(String loc) {
		this.loc = loc;
	}

	
	
}

