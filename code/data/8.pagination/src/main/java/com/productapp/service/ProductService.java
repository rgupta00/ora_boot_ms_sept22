package com.productapp.service;

import java.util.*;

import org.springframework.data.domain.Page;

import com.productapp.entity.Product;

public interface ProductService {
	
	public List<Product> getAll();
	
	public List<Product> findProductsWithSorting(String field);

	public Page<Product> findProductsWithPagination(int offset, int pageSize);

	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field);

}
