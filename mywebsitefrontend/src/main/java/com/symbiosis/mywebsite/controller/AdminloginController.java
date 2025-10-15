package com.symbiosis.mywebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symbiosis.mywebsite.model.Adminlogin;
import com.symbiosis.mywebsite.service.AdminloginService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/")
public class AdminloginController {

    @Autowired
    private AdminloginService adminService;

    
    @GetMapping("/admins")
    public List<Adminlogin> getAllAdmins() {
    	List<Adminlogin> ls= adminService.getAll();
        return ls;
    }

    @PostMapping("/admins")
    public ResponseEntity<Adminlogin> addAdmin(@Valid @RequestBody Adminlogin admin) {
        Adminlogin savedAdmin = adminService.insert(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

   
    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id") int id) {
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   
    @PutMapping("/admins/{id}")
    public ResponseEntity<Adminlogin> updateAdmin(@PathVariable("id") int id, @Valid @RequestBody Adminlogin admin) {
        Adminlogin updatedAdmin = adminService.update(id, admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

   
    @GetMapping("/admins/{id}")
    public ResponseEntity<Adminlogin> getAdminById(@PathVariable("id") int id) {
        Adminlogin admin = adminService.search(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    
    @GetMapping("/admins/login/{email}/{password}")
    public ResponseEntity<List<Adminlogin>> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        List<Adminlogin> admins = adminService.login(email, password);
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
}

