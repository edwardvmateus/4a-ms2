package com.lagranja.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Order {

    @Id
    private Integer orderId;
    private Integer customerId;
    private List<Product> productList;
    private Integer orderTotalPrice;
    private Date orderDate;
    private Integer sellerId;

    public Order(Integer orderId, Integer customerId, List<Product> productList, Integer orderTotalPrice, Date orderDate, Integer sellerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productList = productList;
        this.orderTotalPrice = orderTotalPrice;
        this.orderDate = orderDate;
        this.sellerId = sellerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = this.productList;
    }

    public Integer getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Integer orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
}
