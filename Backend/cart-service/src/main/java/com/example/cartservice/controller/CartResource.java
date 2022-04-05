package com.example.cartservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Product;
import com.example.cartservice.repository.CartRepository;




@Controller
@RestController
@RequestMapping("/getcart")
public class CartResource {
	
	/*
	 * @Autowired private CartService cartservice
	 */
	
	@Autowired
	private CartRepository cartrepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET, value="/cart")
	public List<Cart> getallcart(){
		return cartrepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/product")
	public List<Object> getallproducts() {
	Object[] objects = restTemplate.getForObject("http://product-service/getproduct/product", Object[].class);
	return Arrays.asList(objects);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/cart/{id}")
	public Optional<Cart> getcart(@PathVariable int id){
		return cartrepository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/cart")
	public void addOrder(@RequestBody Cart cart) {
		cartrepository.save(cart);
		
	}
/*	@RequestMapping(method = RequestMethod.POST, value="/create/userId")
	public void addOrder(@RequestBody Cart cart) {
		cartrepository.save(cart);
		System.out.println(cart.getUserId());
	}*/
	
	
/*
 * public List<Object> getProduct(@PathVariable("productid") int productid){
 * Product product =
 * restTemplate.getForObject("http://product-service/getproduct/product",
 * product); System.out.println(product); return Arrays.asList(product); }
 */
	 
	
	@RequestMapping(method = RequestMethod.DELETE, value="cart/{id}")
	public int deletecart(@PathVariable int id) {
		cartrepository.deleteById(id);
		return id;
	}
	
}
