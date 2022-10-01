package com.productapp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.productapp.entity.Product;

@Repository
public interface ProductDao extends MongoRepository<Product, String>{
}