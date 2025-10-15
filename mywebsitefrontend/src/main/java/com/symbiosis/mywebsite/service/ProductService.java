package com.symbiosis.mywebsite.service;

import java.util.List;

import com.symbiosis.mywebsite.model.Product;

public interface ProductService {
	Product insert(Product p);
	void delete(int id);
	Product update(int id,Product p);
	Product search(int id);
	List<Product> getAll();
	List<Product> findAllByCategory(String category);
}