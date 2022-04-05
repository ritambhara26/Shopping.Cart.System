package com.shopping.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ProductId")
public class IdGenerator {

	@Id
	String id;
	int sequence;
	
	public IdGenerator() {
		
	}

	public IdGenerator(String id, int sequence) {
		super();
		this.id = id;
		this.sequence = sequence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "IdGenerator [id=" + id + ", sequence=" + sequence + "]";
	}
	
	
}
