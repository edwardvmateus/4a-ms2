package com.lagranja.product_ms.repositories;

import com.lagranja.product_ms.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository <Order, Integer> {
    List<Order> findByOrderId (Integer orderId);
    List<Order> findByCustomerId (Integer customerId);
    List<Order> findBySellerId (Integer sellerId);
}
