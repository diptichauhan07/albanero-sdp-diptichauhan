package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.user;
import com.example.demo.repository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository repository;
	
	public user getByusername (String username)
	{
		return repository.findByusername(username);
	}
	
	public void delete(String username) 
	{
		user u= repository.findByusername(username);
		repository.delete(u);
	}
	
	public void deleteuser(user user)
	{
		repository.delete(user);
	}
	public user update(String username) 
	{
		user u= repository.findByusername(username);
		String str = u.full_name;
		str = str.replaceAll("[aeiouAEIOU]" , "@#");
		u.full_name = str;
		return repository.save(u);
	}
}
