package com.project.productreadservice.products.services;

import com.project.productreadservice.products.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
