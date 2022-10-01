package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.entity.Product;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.repo.ProductDao;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAll() {
//		if(1==1)
//			throw new RuntimeException();
		return productDao.findAll();
	}

	@Override
	public Product getById(String id) {
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product with id" + id + " is not found"));
	}

	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	@Override
	public Product updateProduct(String id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

	@Override
	public Product deleteProduct(String id) {
		Product productToDelete= getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

}