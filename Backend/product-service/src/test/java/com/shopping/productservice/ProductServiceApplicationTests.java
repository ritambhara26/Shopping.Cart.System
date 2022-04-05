package com.shopping.productservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.productservice.controller.ProductResource;
import com.shopping.productservice.model.Product;
import com.shopping.productservice.repository.ProductRepository;
import com.shopping.productservice.service.ProductService;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {

	
	  @Mock 
	  private ProductRepository productrepository;
	  
	  @InjectMocks 
	  private ProductResource productresource;
	  
	  @Autowired
	  private ProductService productservice;
	  
	  public List<Product> product;
	  

	//TEST GET USER
	@Test
	public void getUsersTest() {
	when(productrepository.findAll()).thenReturn(Stream.of(new Product(1,
			"boAt Rockers Bluetooth Headset","null","This headset comes with the Fast Charge Technology",4,4000)).collect(Collectors.toList()));
	assertEquals(2, productservice.getAllprod().size());
	}
	

}