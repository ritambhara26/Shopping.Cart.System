package com.shopping.orderservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopping.orderservice.model.Order;
import com.shopping.orderservice.service.OrderService;



@Controller
@RestController
@RequestMapping("/getorder")
public class OrderResource {

	@Autowired
	private OrderService orderservice;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET, value="/order")
	public List<Order> getAllord()
	{
		return orderservice.getAllord();
	}
	@RequestMapping(method = RequestMethod.GET, value="/product")
	public List<Object> getallproducts() {
	Object[] objects = restTemplate.getForObject("http://product-service/getproduct/product", Object[].class);
	return Arrays.asList(objects);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/order")
	 public void addord(@RequestBody Order ords) 
	{
		 orderservice.addord(ords);
		 System.out.println("Order Accepted");
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/order/{orderid}")
	public void deleteord(@PathVariable int orderid)
	{
		orderservice.deleteord(orderid);
	}
}


