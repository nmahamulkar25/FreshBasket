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

import com.symbiosis.mywebsite.model.Register;
import com.symbiosis.mywebsite.service.RegisterService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/")
public class RegisterController {
	@Autowired
	private RegisterService es;
	@GetMapping("/registers")
	public List<Register> getallemps()
	{
		List<Register>ls=es.getAll();
		return ls;
	}
	@PostMapping("/registers")
	public ResponseEntity<Register> addem (@Valid @RequestBody Register e)
	{
		Register em=es.insert(e);
		return new ResponseEntity<Register>(em,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/registers/{id}")
	public ResponseEntity<Void>del(@PathVariable("id")int id)
	{
		es.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/registers/{id}")
	public ResponseEntity<Register>update(@PathVariable("id")int id,@Valid @RequestBody Register emp)
	{
		Register em=es.update(id,emp);
		return new ResponseEntity<Register>(em,HttpStatus.OK);
	}
	@GetMapping("/registers/{id}")
	public ResponseEntity<Register>search(@PathVariable("id")int id)
	{
		Register em=es.search(id);
		return new ResponseEntity<Register>(em,HttpStatus.OK);
	}
	@GetMapping("/registers/{email}/{password}")
	public ResponseEntity<List<Register>>login(@PathVariable("email")String email,@PathVariable("password")String password)
	{
		List<Register> em=es.login(email,password);
		return new ResponseEntity<List<Register>>(em,HttpStatus.OK);
	}
	@GetMapping("/registers/{email}")
	public ResponseEntity<Register>searchbyemail(@PathVariable("email")String email)
	{
		Register em=es.searchByEmail(email);
		return new ResponseEntity<Register>(em,HttpStatus.OK);
	}
	
	
}
