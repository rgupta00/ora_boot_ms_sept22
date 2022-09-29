package com.bankapp.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class AccountDto {
	private int id;
	@NotNull(message = "{accountDto.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{accountDto.name.invalid}")
	private String name;

	@NotNull(message = "{accountDto.balance.absent}")
	@Range(min = 100, max = 100000, message = "{accountDto.balance.invalid}")
	private BigDecimal balance;

	public AccountDto(String name, BigDecimal balance) {
		this.name = name;
		this.balance = balance;
	}
	
	
}
