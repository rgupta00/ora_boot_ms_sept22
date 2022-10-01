package com.productapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.productapp.dto.Product;

@Service
public class ProduceService {
	
	@Autowired
	private KafkaTemplate<String, Product>kafkaTemplate;
	
	public void produce(Product product) {
		System.out.println("message is send....");
		kafkaTemplate.send("testdemo", product);
	}
}