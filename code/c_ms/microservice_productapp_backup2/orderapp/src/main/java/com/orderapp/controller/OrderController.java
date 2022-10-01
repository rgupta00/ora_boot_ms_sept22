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
import com.orderapp.service.CouponService;
import com.orderapp.service.CustomerService;
import com.orderapp.service.ProductService;

@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private CouponService couponService;
	
	@PostMapping(path = "orders")
	public ResponseEntity<Order> submitOrder(@RequestBody OrderRequest orderRequest) {
		// i need to get the information from the different app

		// product app
		Product product = productService.getProducts(orderRequest.getPid());
		// customer app
		Customer customer = customerService.getCustomers(orderRequest.getCid());
		// coupon app
		Coupon coupon = couponService.getCoupons(orderRequest.getCouponCode());

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
