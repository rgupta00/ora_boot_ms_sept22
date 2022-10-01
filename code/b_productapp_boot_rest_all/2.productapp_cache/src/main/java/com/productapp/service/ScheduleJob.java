package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleJob {

	@Autowired
	private ProductService productService;
	
	@Scheduled(initialDelay = 5000, fixedRate = 6000)
	public void fixedRate() {
		productService.evictCache();
		log.info("is is runninng after each 6sec");
	}
}
