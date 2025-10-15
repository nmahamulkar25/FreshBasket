package com.symbiosis.mywebsite.service;

import java.util.List;

import com.symbiosis.mywebsite.model.Cart;

public interface CartService {
	Cart insert(Cart c);
	void delete(int id);
	Cart update(int id,Cart c);
	Cart search(int id);
	List<Cart> getAll();
	List<Cart> findAllByEmail(String email);
	
}
