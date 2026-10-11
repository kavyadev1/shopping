package com.example.product_service;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping ("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
    @DeleteMapping ("/products/{id}")
    public void deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    Product existing = productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

    existing.setName(updatedProduct.getName());
    existing.setPrice(updatedProduct.getPrice());
    existing.setQuantity(updatedProduct.getQuantity());

    return productRepository.save(existing);
}

}