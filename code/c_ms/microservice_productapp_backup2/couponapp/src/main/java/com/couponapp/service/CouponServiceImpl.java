package com.couponapp.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.couponapp.entity.Coupon;
@Service
public class CouponServiceImpl implements CouponService {

	public Coupon getCoupon(String couponCode) {
		Coupon coupon=new Coupon(1, "SUP02", 2, LocalDate.of(2022, 12, 11));
		
		if(couponCode.equalsIgnoreCase("SUP10")) {
			coupon=new Coupon(1, "SUP10", 10, LocalDate.of(2022, 12, 11)); 
		}else if(couponCode.equalsIgnoreCase("SUP20")) {
			coupon=new Coupon(1, "SUP20", 20, LocalDate.of(2022, 12, 11)); 
		}else if(couponCode.equalsIgnoreCase("SUP30")) {
			coupon=new Coupon(1, "SUP30", 30, LocalDate.of(2022, 12, 11)); 
		}
		
		return coupon;
	}
}
