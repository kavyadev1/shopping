package com.example.product_service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product createProduct( Product product) {
        return productRepository.save(product);
    }

    
    public Product getProductById( Long id){
        return productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

       public Product updateProduct( Long id,  Product updatedProduct) {
    Product existing = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    existing.setName(updatedProduct.getName());
    existing.setPrice(updatedProduct.getPrice());
    existing.setQuantity(updatedProduct.getQuantity());

    return productRepository.save(existing);
}

public void deleteProductById( Long id){
        productRepository.deleteById(id);
    }
}
