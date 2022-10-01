package com.productapp.service;

import java.util.List;

import com.productapp.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product getById(String id);
	public Product addProduct(Product product);
	public Product updateProduct(String id, Product product);
	public Product deleteProduct(String id);
	
}
