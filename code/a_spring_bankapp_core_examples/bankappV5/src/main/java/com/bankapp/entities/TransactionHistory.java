package com.bankapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "tx_history_table")
public class TransactionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int txId;
	
	private int fromAccId;
	private int toAccId;
	private BigDecimal amount;
	private String txType;
	private LocalDateTime dateTime;
	
	public TransactionHistory(int fromAccId, int toAccId, BigDecimal amount, String txType, LocalDateTime dateTime) {
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
		this.txType = txType;
		this.dateTime = dateTime;
	}
	
	
	
	
}





