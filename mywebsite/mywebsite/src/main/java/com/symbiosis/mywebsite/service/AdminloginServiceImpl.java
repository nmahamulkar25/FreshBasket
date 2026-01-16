package com.symbiosis.mywebsite.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.symbiosis.mywebsite.exception.ResourceNotFoundException;
import com.symbiosis.mywebsite.model.Adminlogin;
import com.symbiosis.mywebsite.repository.AdminloginRepository;
@Service
public class AdminloginServiceImpl implements AdminloginService{
@Autowired
@Qualifier("adminRepo")
private AdminloginRepository adminRepo;
@Override
public Adminlogin insert(Adminlogin a) {
return adminRepo.save(a);
}
@Override
public void delete(int id) {
Adminlogin r=adminRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"+id));
adminRepo.deleteById(id);
 }
  @Override
  public Adminlogin update(int id, Adminlogin a) {
   Adminlogin existingAdmin = adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin with id " + id + " not found"));
   existingAdmin.setEmail(a.getEmail());
   existingAdmin.setPassword(a.getPassword());
   return adminRepo.save(existingAdmin);
}
 @Override
  public Adminlogin search(int id) {
    return adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin with id " + id + " not found"));
 }
 @Override
  public List<Adminlogin> getAll() {
   return adminRepo.findAll();
  }
 @Override
  public List<Adminlogin> login(String email, String password) {
     return adminRepo.findAllByEmailAndPassword(email, password);
  }
}