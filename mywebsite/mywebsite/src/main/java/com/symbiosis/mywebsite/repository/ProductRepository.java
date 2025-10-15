package com.symbiosis.mywebsite.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.mywebsite.model.Product;



@Repository
@Qualifier("productRepo")
public interface ProductRepository extends JpaRepository<Product,Integer> {
	List<Product> findAllByCategory(String category);
	
}