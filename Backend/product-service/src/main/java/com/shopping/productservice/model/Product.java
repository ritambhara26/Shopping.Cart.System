package com.shopping.productservice.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
@Document("Product")
public class Product {
	
	@Transient
	public static final String SEQUENCE_NAME = "prod_sequence";
	
	
	/*
	 * private @Getter @Setter int productid; private @Getter @Setter String
	 * productname; private @Getter @Setter String category; private @Getter @Setter
	 * double price; private @Getter @Setter String desc; private @Getter @Setter
	 * int quantity;
	 */
	 
	
	  @Id 
	  int productid;
	  
	  @Field //@NotNull(message="Product name should not be null") 
	  String productname;
	  
	  String prodimage;
	  
	  String description;
	  
	  int quantity;
	  
	  int price;

	  public Product() {
		  
	  }
	public Product(int productid, String productname,String prodimage, String description, int quantity, int price) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.prodimage = prodimage; 
		this.description = description;
		this.quantity = quantity;
		this.price = price;
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
	public String getProdimage() {
		return prodimage;
	}
	public void setProdimage(String prodimage) {
		this.prodimage = prodimage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", prodimage=" + prodimage
				+ ", description=" + description + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	  
}