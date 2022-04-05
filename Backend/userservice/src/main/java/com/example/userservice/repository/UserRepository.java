package com.example.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.model.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{

	UserModel findByusername(String username);

}
