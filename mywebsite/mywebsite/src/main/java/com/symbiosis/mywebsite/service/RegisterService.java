package com.symbiosis.mywebsite.service;

import java.util.List;

import com.symbiosis.mywebsite.model.Register;

public interface RegisterService {
Register insert(Register r);
void delete(int id);
Register update(int id,Register r);
Register search(int id);
List<Register> getAll();
List<Register>login(String email,String Password);
Register searchByEmail(String email);

}
