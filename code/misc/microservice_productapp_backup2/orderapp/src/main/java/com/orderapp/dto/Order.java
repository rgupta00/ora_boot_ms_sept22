package com.orderapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private String id;
	private double totalPrice;
	private LocalDate orderDate;
	private Customer customer;
	private Product product;

}