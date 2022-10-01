package com.orderapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class CouponService {

	@Autowired
	private RestTemplate restTemplate;
	
	public Coupon fallbackCoupon(Exception e) {
		System.out.println("-------------------------");
		System.out.println(e);
		return new Coupon(121, "SUP02", 2, LocalDate.now());
	}
	@CircuitBreaker(fallbackMethod ="fallbackCoupon" , name = "couponservice")
	public Coupon getCoupons(String couponCode) {
		return restTemplate
				.getForObject("http://COUPON-SERVICE/couponapp/coupons/" + couponCode, Coupon.class);
	}
}
