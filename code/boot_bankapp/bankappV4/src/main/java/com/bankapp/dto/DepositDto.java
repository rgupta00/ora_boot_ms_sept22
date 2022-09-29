package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class DepositDto {
	private int accId;
	private BigDecimal amount;
}
