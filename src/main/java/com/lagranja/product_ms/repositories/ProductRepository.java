package com.lagranja.product_ms.repositories;

import com.lagranja.product_ms.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <Product, Integer> {

}
