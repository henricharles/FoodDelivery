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
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public List<Customer> getCustomerByID(int id){
		List<Customer> customers = customerDao.findAll();
		return customers;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}


	@Override
	public Customer findOne(int id) {
		// TODO Auto-generated method stub
		return customerDao.findOne(id);
	}
	
	@Override
	public Customer findByUsername(String userName){
		return customerDao.findByUsername(userName);
	}
}
