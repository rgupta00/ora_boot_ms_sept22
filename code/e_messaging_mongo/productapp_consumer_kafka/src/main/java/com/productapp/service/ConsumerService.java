package com.productapp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.productapp.dto.Product;

@Service
public class ConsumerService {
	@KafkaListener(topics = "testdemo", groupId = "my_topic_group_id")
	public void consume(Product product) {
		System.out.println(product);
	}
}