package com.shopping.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.orderservice.model.Order;
import com.shopping.orderservice.repository.OrderRepository;





@Service
public class OrderService {

	@Autowired
	private OrderRepository orderrepository;

	public List<Order> getAllord()
	{
		List<Order> ords = new ArrayList<>();
		orderrepository.findAll()
		.forEach(ords::add);
		return ords;
	}

	public void addord(Order ords)
	{
		orderrepository.save(ords);
	}
	
	public void deleteord(int orderid)
	{
		orderrepository.deleteById(orderid);
	}
}



