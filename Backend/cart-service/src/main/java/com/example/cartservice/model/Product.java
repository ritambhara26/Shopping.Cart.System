package com.example.cartservice.model;


/*import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;*/

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Product")
public class Product {
	
	@Transient
	public static final String SEQUENCE_NAME = "prod_sequence";
	
	@Id
  int productid;
	
	@Field
	//@NotNull(message="Product name should not be null")
  String productname;
	
	@Field
  String category;
	
	@Field
  double price;
	
	@Field
	String desc;
	
	@Field
	int quantity;
	
  public Product() {
  
  }

public Product(int productid, String productname, String category, double price, String desc, int quantity) {
	super();
	this.productid = productid;
	this.productname = productname;
	this.category = category;
	this.price = price;
	this.desc = desc;
	this.quantity = quantity;
}

public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "Product [productid=" + productid + ", productname=" + productname + ", category=" + category + ", price="
			+ price + ", desc=" + desc + ", quantity=" + quantity + "]";
}
  
  
}