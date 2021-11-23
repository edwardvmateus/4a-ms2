package com.lagranja.product_ms.controllers;

import com.lagranja.product_ms.exceptions.OrderNotFoundException;
import com.lagranja.product_ms.exceptions.ProductNotFoundException;
import com.lagranja.product_ms.models.Order;
import com.lagranja.product_ms.repositories.OrderRepository;
import com.lagranja.product_ms.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderController(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/order")
    Order newOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @GetMapping("/orders/{orderId}")
    Order getOrder(@PathVariable Integer orderId){
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("No se encontró la orden con el orderId: " + orderId));
    }

    @GetMapping("/orders")
    List<Order> listOrders(){
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "orderDate"));
    }

    @DeleteMapping("/orders/{orderId}")
    void deleteOrder(@PathVariable Integer orderId){
        Order orderToDelete = orderRepository.findById(orderId).orElse(null);
        if(orderToDelete == null)
            throw new OrderNotFoundException("No se encontró ninguna orden con el orderId: " + orderId);
        orderRepository.deleteById(orderId);
    }

    @PutMapping("/orders/{orderId}")
    Order updateOrder(@PathVariable Integer orderId, @RequestBody Order newOrder){
        Order oldOrder = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("No se encontró ninguna orden con el orderId: " + orderId));
        oldOrder.setProductList(newOrder.getProductList());
        oldOrder.setOrderTotalPrice(newOrder.getOrderTotalPrice());
        oldOrder.setOrderDate(newOrder.getOrderDate());
        oldOrder.setCustomerId(newOrder.getCustomerId());
        oldOrder.setSellerId(newOrder.getSellerId());
        return orderRepository.save(oldOrder);
    }

}