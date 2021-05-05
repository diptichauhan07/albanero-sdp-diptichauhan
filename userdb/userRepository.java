package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.user;

@Repository
public interface userRepository extends MongoRepository<user, String> {

	public user findByusername(String username);
}
