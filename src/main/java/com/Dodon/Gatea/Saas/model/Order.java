package com.Dodon.Gatea.Saas.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private User waiter;
	@Column
	@ElementCollection
	private List<MenuItem> orderItems;
	
	public Order(List<MenuItem> list, User waiter) {
		this.setWaiter(waiter);
		this.setOrderItems(list);
	}

	public List<MenuItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<MenuItem> orderItems) {
		this.orderItems = orderItems;
	}

	public User getWaiter() {
		return waiter;
	}

	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}
}
