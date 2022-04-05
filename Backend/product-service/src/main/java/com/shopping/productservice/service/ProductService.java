package com.shopping.productservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopping.productservice.model.Product;
import com.shopping.productservice.repository.ProductRepository;

//import antlr.collections.List;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productrepository;
	
	
	public List<Product> getAllprod()
	{
		List<Product> prods = new ArrayList<>();
		productrepository.findAll()
		.forEach(prods::add);
		return prods;
	}

	/*
	 * public List<Product> getProductname(String productname){ return
	 * productrepository.findByName(productname); }
	 */
	public void addprod(Product prods)
	{
		productrepository.save(prods);
	}
	
	public void updateprod(int productid, Product prods) 
	{
		productrepository.save(prods);
	}
	
	public void deleteprod(int productid)
	{
		productrepository.deleteById(productid);
	}
	
}
