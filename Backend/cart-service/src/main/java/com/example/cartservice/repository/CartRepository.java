package com.example.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cartservice.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, Integer>{

	

}
