package service;

import java.util.List;

import domain.Order;

public interface OrderService {
	
	public List<Order> getOrderByID(int id);
	public void save(Order order);
	public Order findOne(int id);
}
