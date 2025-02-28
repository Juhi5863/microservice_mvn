package com.ecommerce.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.entity.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Changed to avoid conflicts
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping // Changed from "/"
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping // Changed from "/"
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
