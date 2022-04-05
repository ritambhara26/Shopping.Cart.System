package com.shopping.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopping.productservice.model.Product;
import com.shopping.productservice.repository.ProductRepository;
import com.shopping.productservice.service.ProductService;
import com.shopping.productservice.service.SequenceGeneratorService;

@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping("/getproduct")
public class ProductResource {
	@Autowired
	private ProductService productservice;
	
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SequenceGeneratorService service;
	
	public ProductResource(ProductService productservice) {
		this.productservice = productservice;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/product")
	public List<Product> getAllprod()
	{
		return productservice.getAllprod();
	}
	/*
	 * @RequestMapping(method = RequestMethod.GET, value="/product/{productname}")
	 * public List<Product> getProductname(@PathVariable("productname") String
	 * productname){ return productservice.getProductname(productname); }
	 */
	/*
	 * @RequestMapping(method = RequestMethod.POST, value="/product") public void
	 * addprod(@RequestBody Product prod) { productservice.addprod(prod);
	 * prod.setId(service.getSequenceNumber(Product.SEQUENCE_NAME)); return
	 * productrepository.save(prod); }
	 */
	
	//@PostMapping("/post")
	@RequestMapping(method = RequestMethod.POST, value="/product") 
	public Product addprod(@RequestBody Product product) {
		product.setProductid(service.getSequenceNumber(Product.SEQUENCE_NAME));
		return productrepository.save(product);
		}
	@RequestMapping(method = RequestMethod.PUT, value="/product/{productid}")
	public void updateprod(@RequestBody Product prod, @PathVariable int productid)
	{
		productservice.updateprod(productid, prod);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/product/{productid}")
	public void deleteprod(@PathVariable int productid)
	{
		productservice.deleteprod(productid);
	}
	@RequestMapping(method = RequestMethod.GET, value="/product/{productid}")
	public Optional<Product> getcart(@PathVariable int productid){
	return productrepository.findById(productid);
	}
	
	
}