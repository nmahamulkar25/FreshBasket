package com.symbiosis.mywebsite.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symbiosis.mywebsite.model.Adminlogin;

@Repository
@Qualifier("adminRepo")
public interface AdminloginRepository extends JpaRepository<Adminlogin,Integer> {
	List<Adminlogin> findAllByEmailAndPassword(String email,String password);

}