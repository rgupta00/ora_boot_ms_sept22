package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProduceService;

@RestController
public class ProducerController {

	@Autowired
	private ProduceService produceService;
	@PostMapping("producer")
	public String callProducer(@RequestBody Product product) {
		produceService.produce(product);
		return "product added";
	}
}
