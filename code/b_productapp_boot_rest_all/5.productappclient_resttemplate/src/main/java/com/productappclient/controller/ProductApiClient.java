package com.productappclient.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productappclient.dto.Product;

@RestController
public class ProductApiClient {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "productclient/{id}")
	public Product getProduct(@PathVariable  int id) {
		return restTemplate.getForObject("http://localhost:8090/productapp/products/"+id, Product.class);
	}
	
//	//----------getting all product with getForObject-------
//	
//	@GetMapping(path = "productclient")
//	public List<?> getProduct() {
//		return restTemplate.getForObject("http://localhost:8090/productapp/products", List.class);
//	}
	
	//----------getting all product with getForEntity-------
	
		@GetMapping(path = "productclient")
		public List<?> getProduct() {
			
			 ResponseEntity<?> forEntity =
					 restTemplate.getForEntity("http://localhost:8090/productapp/products", List.class);
			 System.out.println(forEntity.getStatusCode());
			 System.out.println(forEntity.getHeaders());
			 System.out.println("------------------------------------------------");
			 return (List<?>) forEntity.getBody();
			 
		}
	
}






