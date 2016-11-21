package service;

import java.util.List;

import domain.Order;

public interface OrderService {
	
	public List<Order> getOrderByID(int id);

}
