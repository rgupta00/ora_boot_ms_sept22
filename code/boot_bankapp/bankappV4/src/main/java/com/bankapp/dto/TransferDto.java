package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class TransferDto {
	private int fromAccId;
	private int toAccId;
	private BigDecimal amount;
}
