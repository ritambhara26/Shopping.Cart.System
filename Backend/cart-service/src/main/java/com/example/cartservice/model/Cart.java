package com.example.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Cart")
public class Cart {

	@Id
	int id;
	
	int items;

	public Cart() {
		
	}

	public Cart(int id, int items) {
		super();
		this.id = id;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", items=" + items + "]";
	}

	
}
