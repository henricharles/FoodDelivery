package service;

import java.util.List;

import domain.Customer;
import domain.Order;

public interface CustomerService {
	
	public List<Customer> getCustomerByID(int id);
	public void save(Customer customer);
	public Customer findOne(int id);
}
