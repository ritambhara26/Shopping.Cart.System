package com.shopping.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.orderservice.model.Order;


@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
	public Order findById(int orderid);
}
