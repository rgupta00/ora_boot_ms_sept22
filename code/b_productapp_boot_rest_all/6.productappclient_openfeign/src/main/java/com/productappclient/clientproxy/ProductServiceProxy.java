package com.productappclient.clientproxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.productappclient.dto.Product;
@FeignClient(name="product-service", url = "http://localhost:8090/productapp/products")
public interface ProductServiceProxy {
	
	@GetMapping
	public  ResponseEntity<List<Product>> findAll();
	
	@GetMapping(path = "/{id}")
	public Product findById(@PathVariable(name = "id") int id);
	
	@PostMapping
	public ResponseEntity<Product> addProduct( @RequestBody @Valid  Product product);
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") int id);
	
	@PutMapping(path = "/{id}")
	public Product updateProduct(@PathVariable(name = "id") int id, @RequestBody @Valid Product product);
}
