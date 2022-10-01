package com.orderapp.controller;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.Order;
import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.Product;

@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(path = "orders")
	public ResponseEntity<Order> submitOrder(@RequestBody OrderRequest orderRequest) {
		// i need to get the information from the different app

		// product app
		Product product = restTemplate
				.getForObject("http://localhost:8082/productapp/products/" + orderRequest.getPid(), Product.class);
		// customer app
		Customer customer = restTemplate
				.getForObject("http://localhost:8081/customerapp/customers/" + orderRequest.getCid(), Customer.class);
		// coupon app
		Coupon coupon = restTemplate
				.getForObject("http://localhost:8085/couponapp/coupons/" + orderRequest.getCouponCode(), Coupon.class);

		double totalPrice = product.getPrice().doubleValue() * orderRequest.getQuantity();
		double discountedPrice = totalPrice * (100 - coupon.getDiscountPercentage()) / 100;

		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setCustomer(customer);
		order.setProduct(product);
		order.setTotalPrice(discountedPrice);
		order.setOrderDate(LocalDate.now());
		return ResponseEntity.status(HttpStatus.CREATED).body(order);

	}
}
