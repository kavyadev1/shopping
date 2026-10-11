package com.example.product_service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @GetMapping("/products")
        public List<Product> getAllProducts(){
            return productRepository.findAll();
        }
    
}