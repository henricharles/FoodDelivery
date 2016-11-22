package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import dao.OrderDao;
import domain.Customer;
import domain.Order;
import domain.Product;

@Service
public class OrderImpl implements OrderService {
	
	@Autowired
	OrderDao OrdDAO;
	
	@Autowired
	CustomerDao CustDAO;
	
	public List<Order> getOrderByID(int id){
		Customer cust = CustDAO.findOne(id);
		List<Order> CustomerOrder = OrdDAO.findBycustomer(cust);
		return CustomerOrder;
	}
}
