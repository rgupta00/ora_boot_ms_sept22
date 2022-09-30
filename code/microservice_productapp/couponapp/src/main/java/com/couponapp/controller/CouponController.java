package com.couponapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.couponapp.entity.Coupon;
import com.couponapp.service.CouponService;

@RestController
public class CouponController {
	
	@Autowired
	private CouponService couponService;
	@GetMapping(path = "coupons/{couponCode}")
	public Coupon getCoupon(@PathVariable  String couponCode) {		
		return couponService.getCoupon(couponCode);
	}
}
