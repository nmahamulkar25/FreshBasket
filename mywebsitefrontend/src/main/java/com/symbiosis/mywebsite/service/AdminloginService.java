package com.symbiosis.mywebsite.service;

import java.util.List;


import com.symbiosis.mywebsite.model.Adminlogin;
import com.symbiosis.mywebsite.model.Register;

public interface AdminloginService {
	Adminlogin insert(Adminlogin a);
	void delete(int id);
	Adminlogin update(int id,Adminlogin a);
	Adminlogin search(int id);
	List<Adminlogin> getAll();
	List<Adminlogin> login(String email, String password);
	
}