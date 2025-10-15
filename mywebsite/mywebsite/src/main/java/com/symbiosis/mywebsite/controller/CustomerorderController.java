package com.symbiosis.mywebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symbiosis.mywebsite.model.Customerorder;
import com.symbiosis.mywebsite.service.CustomerorderService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class CustomerorderController {

    @Autowired
    private CustomerorderService orderService;

   
    @GetMapping("/orders")
    public List<Customerorder> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping("/orders")
    public ResponseEntity<Customerorder> addOrder(@Valid @RequestBody Customerorder order) {
        Customerorder newOrder = orderService.insert(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

  
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") int id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

 
    @PutMapping("/orders/{id}")
    public ResponseEntity<Customerorder> updateOrder(
            @PathVariable("id") int id, 
            @Valid @RequestBody Customerorder order) {
        Customerorder updatedOrder = orderService.update(id, order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

 
    @GetMapping("/orders/{id}")
    public ResponseEntity<Customerorder> getOrderById(@PathVariable("id") int id) {
        Customerorder order = orderService.search(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

  
    @GetMapping("/orders/{email}")
    public ResponseEntity<List<Customerorder>> getOrdersByEmail(@PathVariable("email") String email) {
        List<Customerorder> orders = orderService.findAllByEmail(email);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

  
}
