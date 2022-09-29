package com.bankapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "card_table")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cardType;
	private BigDecimal maxLimit;

	private LocalDateTime expiryDate;
	
}
