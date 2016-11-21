package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderDao;
import domain.Order;
import domain.Product;

@Service
public class OrderImpl implements OrderService {
	
	@Autowired
	OrderDao OrdDAO;
	
	public List<Order> getOrderByID(int id){
		List<Order> CustomerOrder = OrdDAO.findBycustomer(id);
		return CustomerOrder;
	}
}
