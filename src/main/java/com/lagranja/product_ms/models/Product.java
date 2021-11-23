package com.lagranja.product_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Product {

    @Id
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private String productDescription;
    private Boolean isProductInStock;
    private Integer sellerId;
    private String sellerName;
    private Integer quantity;
    //private Integer adminId;
    //private Date date;

    public Product(Integer productId, String productName, Integer productPrice, String productDescription, Boolean isProductInStock, Integer sellerId, String sellerName, Integer quantity/*, Integer adminId, Date date*/) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.isProductInStock = isProductInStock;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.quantity = quantity;
        //this.adminId = adminId;
        //this.date = date;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Boolean getProductInStock() {
        return isProductInStock;
    }

    public void setProductInStock(Boolean productInStock) {
        isProductInStock = productInStock;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
/*
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

 */
}
