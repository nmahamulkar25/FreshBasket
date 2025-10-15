package com.symbiosis.mywebsite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symbiosis.mywebsite.model.Product;
import com.symbiosis.mywebsite.service.ProductService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductService productService;

    
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

  
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.insert(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

   
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @Valid @RequestBody Product product) {
        Product updatedProduct = productService.update(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

  
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Product product = productService.search(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

   
    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
        List<Product> products = productService.findAllByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

