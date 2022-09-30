package com.productapp.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.productapp.entity.Product;

public interface ProductService {
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
	public List<Product> findAll();
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
	public Product getById(int id);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Product addProduct(Product product);
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Product updateProduct(int id, Product product);
	
	@PostAuthorize("returnObject.vendorName==authentication.name")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MGR')")
	public Product deleteProduct(int id);
	
}
