package com.symbiosis.mywebsite.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.symbiosis.mywebsite.exception.ResourceNotFoundException;
import com.symbiosis.mywebsite.model.Cart;
import com.symbiosis.mywebsite.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	@Qualifier("cartRepo")
	private CartRepository cartRepo;

	@Override
    public Cart insert(Cart c) {
        return cartRepo.save(c);
    }

    @Override
    public void delete(int id) {
        if (!cartRepo.existsById(id)) {
            throw new ResourceNotFoundException("Cart item with id " + id + " not found");
        }
        cartRepo.deleteById(id);
    }

    @Override
    public Cart update(int id, Cart c) {
        Cart existingCart = cartRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item with id " + id + " not found"));

        // Update fields
        existingCart.setUsername(c.getUsername());
        existingCart.setEmail(c.getEmail());
        existingCart.setProductName(c.getProductName());
        existingCart.setQuantity(c.getQuantity());
        existingCart.setTotal(c.getTotal());
        // Add more fields as necessary

        return cartRepo.save(existingCart);
    }

    @Override
    public Cart search(int id) {
        return cartRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart item with id " + id + " not found"));
    }

    @Override
    public List<Cart> getAll() {
        return cartRepo.findAll();
    }

    

    @Override
    public List<Cart> findAllByEmail(String email) {
        return cartRepo.findAllByEmail(email);
    }
}
