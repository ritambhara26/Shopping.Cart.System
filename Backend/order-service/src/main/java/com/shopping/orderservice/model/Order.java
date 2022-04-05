package com.shopping.orderservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Order")
public class Order {
	@Id
	int orderid;
	
	@Field
	Date orderdate;
	
	@Field
	int custid;
	
	@Field
	int amount;

	@Field
	String status;
	
	public Order() {
		
	}


	public Order(int orderid, Date orderdate, int custid, int amount, String status) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.custid = custid;
		this.amount = amount;
		this.status = status;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}




	public int getUserid() {
		return custid;
	}




	public void setUserid(int custid) {
		this.custid = custid;
	}




	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderdate=" + orderdate + ", custid=" + custid + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	
	
}
