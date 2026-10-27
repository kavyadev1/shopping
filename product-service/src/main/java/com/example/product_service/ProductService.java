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
    
    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
        .stream()
        .map(this::toResponse)
        .toList();
    }
    
    public ProductResponse createProduct(ProductRequest request) {
    Product product = toEntity(request);
    Product saved = productRepository.save(product);
    return toResponse(saved);
    }

    public Long countProduct(){
        return productRepository.count();
    }

    

    public ProductResponse getProductById (Long id){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return toResponse(product);
        

    }


public ProductResponse updateProduct (Long id , ProductRequest request){

Product existing = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    existing.setName(request.getName());
    existing.setPrice(request.getPrice());
    existing.setQuantity(request.getQuantity());
    Product saved = productRepository.save(existing);

    return toResponse(saved);
     
}
public void deleteProductById( Long id){
        productRepository.deleteById(id);
    }

    private ProductResponse toResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        return response;

    }

    private Product toEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        return product;
    }
}
