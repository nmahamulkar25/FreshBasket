package com.symbiosis.mywebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.symbiosis.mywebsite.model.Customerorder;
import com.symbiosis.mywebsite.repository.CustomerorderRepository;

@Service
public class CustomerorderServiceImpl implements CustomerorderService {

    @Autowired
    private CustomerorderRepository customerorderRepo;

   
    @Override
    public Customerorder insert(Customerorder order) {
        return customerorderRepo.save(order);
    }

   
    @Override
    public void delete(int id) {
        if (customerorderRepo.existsById(id)) {
            customerorderRepo.deleteById(id);
        } else {
            throw new RuntimeException("Order with ID " + id + " not found");
        }
    }

   
    @Override
    public Customerorder update(int id, Customerorder order) {
        Customerorder existingOrder = customerorderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));

        
        existingOrder.setProductName(order.getProductName());
        existingOrder.setEmail(order.getEmail());
        existingOrder.setContactNo(order.getContactNo());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setTotal(order.getTotal());

       

        return customerorderRepo.save(existingOrder);
    }

    @Override
    public Customerorder search(int id) {
        return customerorderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    
    @Override
    public List<Customerorder> getAll() {
        return customerorderRepo.findAll();
    }

  
    @Override
    public List<Customerorder> findAllByEmail(String email) {
        return customerorderRepo.findAllByEmail(email);
    }

   
    @Override
    public Customerorder findByEmail(String email) {
        return customerorderRepo.findByEmail(email);
    }
}
