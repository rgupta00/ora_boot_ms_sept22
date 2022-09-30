package com.orderapp.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@ToString

public class Product {
	
	private Integer id;

	private String name;
	
	private BigDecimal price;
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
}
