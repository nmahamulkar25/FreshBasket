package com.symbiosis.mywebsite.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.mywebsite.model.Customerorder;

@Repository
public interface CustomerorderRepository extends JpaRepository<Customerorder, Integer> {

    
    List<Customerorder> findAllByEmail(String email);

    Customerorder findByEmail(String email);
}
