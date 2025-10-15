package com.symbiosis.mywebsite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.mywebsite.model.Register;



@Repository
@Qualifier("regRepo")
public interface RegisterRepository extends JpaRepository<Register,Integer> {
	

	
	Register searchByEmail(String email);
	List<Register> findByEmailAndPassword(String email, String password);
	
	
	

}