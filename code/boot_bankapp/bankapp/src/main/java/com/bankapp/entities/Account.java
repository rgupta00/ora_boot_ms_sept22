package com.bankapp.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_table")
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
	@NotNull(message = "{account.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{account.name.invalid}")
	@Column(name = "acc_name")
	private String name;

	@NotNull(message = "{account.balance.absent}")
	@Range(min = 100, max = 100000, message = "{account.balance.invalid}")
	@Column(name = "acc_balance")
	private BigDecimal balance;
    
    private String phone;
	private String address;
	public Account(String name, BigDecimal balance, String phone, String address) {
		super();
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.address = address;
	} 
}