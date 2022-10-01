package com.productappclient.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productappclient.clientproxy.ProductServiceProxy;
import com.productappclient.dto.Product;

@RestController
public class ProductApiClient {

	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@GetMapping(path = "productclient/{id}")
	public Product getProduct(@PathVariable int id) {
		System.out.println(productServiceProxy.getClass());
		return productServiceProxy.findById(id);
	}

	@GetMapping(path = "productclient")
	public ResponseEntity<List<Product>> getProduct() {
		return productServiceProxy.findAll();
	}

}
