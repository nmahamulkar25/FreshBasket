package com.symbiosis.mywebsite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.mywebsite.model.Cart;



@Repository
@Qualifier("cartRepo")
public interface CartRepository extends JpaRepository<Cart,Integer> {
	List<Cart> findAllByEmail(String email);


}
