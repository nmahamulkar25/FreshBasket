package com.symbiosis.mywebsite.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.symbiosis.mywebsite.model.Cart;
import com.symbiosis.mywebsite.service.CartService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/")
public class CartController {

    @Autowired
    private CartService cartService;

   
    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getAllCartItems() {
        List<Cart> carts = cartService.getAll();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    
    @PostMapping("/carts")
    public ResponseEntity<Cart> addCartItem(@Valid @RequestBody Cart cart) {
        Cart savedCart = cartService.insert(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int id) {
        cartService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCartItem(@PathVariable int id, @Valid @RequestBody Cart cart) {
        Cart updatedCart = cartService.update(id, cart);
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartItemById(@PathVariable int id) {
        Cart cart = cartService.search(id);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

   
    @GetMapping("/user/{email}")
    public ResponseEntity<List<Cart>> getCartItemsByEmail(@PathVariable String email) {
        List<Cart> carts = cartService.findAllByEmail(email);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }
}

