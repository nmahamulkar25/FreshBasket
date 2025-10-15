package com.symbiosis.mywebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.symbiosis.mywebsite.exception.ResourceNotFoundException;
import com.symbiosis.mywebsite.model.Product;
import com.symbiosis.mywebsite.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    @Qualifier("productRepo")
    private ProductRepository productRepo;

    // Insert a new product
    @Override
    public Product insert(Product p) {
        return productRepo.save(p);
    }

    // Delete a product by id
    @Override
    public void delete(int id) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
        productRepo.delete(existingProduct);
    }

    // Update a product by id
    @Override
    public Product update(int id, Product p) {
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        // Update fields
        existingProduct.setProductname(p.getProductname());
        existingProduct.setImageurl(p.getImageurl());
        existingProduct.setDescription(p.getDescription());
        existingProduct.setPrice(p.getPrice());
        existingProduct.setQuantity(p.getQuantity());
        existingProduct.setCategory(p.getCategory());

        return productRepo.save(existingProduct);
    }

    // Search a product by id
    @Override
    public Product search(int id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
    }

    // Get all products
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

	@Override
	public List<Product> findAllByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepo.findAllByCategory(category);
	}
}
