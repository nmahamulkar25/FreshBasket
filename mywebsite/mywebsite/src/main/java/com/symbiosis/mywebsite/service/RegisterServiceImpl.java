package com.symbiosis.mywebsite.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.symbiosis.mywebsite.exception.ResourceNotFoundException;
import com.symbiosis.mywebsite.model.Register;
import com.symbiosis.mywebsite.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    @Qualifier("regRepo")
    private RegisterRepository regRepo;

    @Override
    public Register insert(Register r) {
        return regRepo.save(r);
    }

    @Override
    public void delete(int id) {
        Register r = regRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found " + id));
        regRepo.deleteById(id);
    }

    @Override
    public Register update(int id, Register r) {
        Register rold = regRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found " + id));

        
        rold.setUsername(r.getUsername());
        rold.setEmail(r.getEmail());
        rold.setContactNo(r.getContactNo());
        rold.setAddress(r.getAddress());
        rold.setPassword(r.getPassword());

        return regRepo.save(rold);
    }

    @Override
    public Register search(int id) {
        return regRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found " + id));
    }

    @Override
    public List<Register> getAll() {
        return regRepo.findAll();
    }

    @Override
    public List<Register> login(String email, String Password) {
        return regRepo.findByEmailAndPassword(email, Password);
    }

	@Override
	public Register searchByEmail(String email) {
		// TODO Auto-generated method stub
		return regRepo.searchByEmail(email);
	}

    
}