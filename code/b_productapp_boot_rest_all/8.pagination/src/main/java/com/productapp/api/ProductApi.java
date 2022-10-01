package com.productapp.api;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;
//http://localhost:8080/products
@RestController
public class ProductApi {

	private ProductService productService;

	@Autowired
	public ProductApi(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(path = "products")
	public List<Product> findAll(){
		return productService.getAll();
	}
	//productswithsorting?field=price
//	findProductsWithSorting(String field);
	@GetMapping(path = "productswithsorting")
	public List<Product> findProductsWithSorting(@RequestParam  String field){
		return productService.findProductsWithSorting(field);
	}

//	public Page<Product> findProductsWithPagination(int offset, int pageSize);
	@GetMapping(path = "findProductsWithPagination")
	public Page<Product> findProductsWithPagination(@RequestParam int offset,@RequestParam int pageSize){
		return productService.findProductsWithPagination(offset, pageSize);
	}
	
//
//	public Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize, String field);
//	
	
}
