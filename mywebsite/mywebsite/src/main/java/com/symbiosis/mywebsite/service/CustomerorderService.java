package com.symbiosis.mywebsite.service;

import java.util.List;
import com.symbiosis.mywebsite.model.Customerorder;

public interface CustomerorderService {
    
    
    Customerorder insert(Customerorder order);
    void delete(int id);
    Customerorder update(int id, Customerorder order);
    Customerorder search(int id);
    List<Customerorder> getAll();
    List<Customerorder> findAllByEmail(String email);
    Customerorder findByEmail(String email);
}
