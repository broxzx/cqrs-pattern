package com.project.productwriteservice.products.services;

import com.project.productwriteservice.products.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {



}
