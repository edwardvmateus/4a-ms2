package com.lagranja.product_ms.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message){
        super(message);
    }
}
