package com.productappclient.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@ToString

public class Product {
	
	private Integer id;
	
	@NotNull(message = "{product.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{product.name.invalid}")
	private String name;
	
	@NotNull(message = "{product.price.absent}")
	@Range(min = 100, max = 100000, message = "{product.price.invalid}")
	private BigDecimal price;
	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
}
