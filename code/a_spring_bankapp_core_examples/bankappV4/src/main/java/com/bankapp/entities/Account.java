package com.bankapp.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "account_table")
public class Account {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_id")
	private int id;
	
	@Column(name = "acc_name")
	private String name;
	
	@Column(name = "acc_balance")
	private BigDecimal balance;

	public Account(String name, BigDecimal balance) {
		this.name = name;
		this.balance = balance;
	}
	
	
}
