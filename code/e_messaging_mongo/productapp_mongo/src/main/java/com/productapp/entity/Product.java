package com.productapp.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@ToString
@Document(collection = "employees")
public class Product {
	@Id
	private String id;
	
	private String name;
	
	private BigDecimal price;
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
}
