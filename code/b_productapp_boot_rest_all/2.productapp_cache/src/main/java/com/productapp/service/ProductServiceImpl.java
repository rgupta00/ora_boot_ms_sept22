package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

	@Cacheable(value = "products")
	@Override
	public List<Product> findAll() {
//		if(1==1)
//			throw new RuntimeException();
		return productDao.findAll();
	}

	@Cacheable(value = "products", key="#result.id")
	@Override
	public Product getById(int id) {
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("product with id" + id + " is not found"));
	}

	@CachePut(value = "products", key="#result.id")
	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	@CachePut(value = "products", key="#result.id")
	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}
	@CacheEvict(value = "products", key="#id")
	@Override
	public Product deleteProduct(int id) {
		Product productToDelete= getById(id);
		productDao.delete(productToDelete);
		return productToDelete;
	}

	@CacheEvict(value = "products", allEntries = true)
	@Override
	public void evictCache() {}

}