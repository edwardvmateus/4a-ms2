package com.lagranja.product_ms.controllers;

import com.lagranja.product_ms.exceptions.ProductNotFoundException;
import com.lagranja.product_ms.models.Product;
import com.lagranja.product_ms.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products/{productId}")
    Product getProduct(@PathVariable Integer productId){
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("No se encontró el producto con el productId: " + productId));
    }

    @GetMapping("/products")
    List<Product> listProducts(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "productPrice"));
    }

    @DeleteMapping("/products/{productId}")
    void deleteProduct(@PathVariable Integer productId){
        Product productToDelete = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("No se encontró el producto con el productId: " + productId));
        productRepository.deleteById(productId);
    }

    @PutMapping("/products/{productId}")
    Product updateProduct(@PathVariable Integer productId, @RequestBody Product newProduct){
        Product oldProduct = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("No se pudo actualizar porque no se encontró el producto con productId: " + productId));
        oldProduct.setProductName(newProduct.getProductName());
        oldProduct.setProductPrice(newProduct.getProductPrice());
        oldProduct.setProductDescription(newProduct.getProductDescription());
        oldProduct.setProductInStock(newProduct.getProductInStock());
        oldProduct.setQuantity(newProduct.getQuantity());
        oldProduct.setSellerId(newProduct.getSellerId());
        oldProduct.setSellerName(newProduct.getSellerName());
        return productRepository.save(oldProduct);
    }

}
