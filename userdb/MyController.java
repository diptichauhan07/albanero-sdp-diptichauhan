package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.user;
import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;

@RestController
public class MyController {

	@Autowired
	private userRepository repository;
	
	@Autowired
	private userService service;
	
	
	@PostMapping("/adduser")
	public user adduser(@RequestBody user user) {
		repository.save(user);
		return user;
	}
	
	@GetMapping("/getuser")
	public List<user> getusers(){
		return repository.findAll();
	}
	
	
	@DeleteMapping("/delete/user/{username}")
	public String delete(@PathVariable String username)
	{
		service.delete(username);
		return "book delete by username : " +username;
	
	}
		
	
	@PutMapping("/update/user/{username}")
	public String update(@PathVariable String username)
	{
		user u = service.update(username);
		return u.toString();
	}
	
}
