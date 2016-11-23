package service;

import java.util.List;

import domain.Order;

public interface OrderService {
	
	public List<Order> getOrderByUserName(String userName);
	public void save(Order order);
	public Order findOne(int id);
}
