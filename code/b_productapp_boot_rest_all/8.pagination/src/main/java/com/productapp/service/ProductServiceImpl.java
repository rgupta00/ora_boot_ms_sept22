package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.productapp.entity.Product;
import com.productapp.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;

	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> findProductsWithSorting(String field) {
		return productRepo.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Page<Product> findProductsWithPagination(int offset, int pageSize) {
		 return productRepo.findAll(PageRequest.of(offset, pageSize));
	}

	@Override
	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
		 return productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

}
