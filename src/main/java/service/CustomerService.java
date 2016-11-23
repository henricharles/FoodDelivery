package service;

import java.util.List;

import domain.Customer;

public interface CustomerService {
	public void createCustomer(Customer customer,String r);
	public void createCustomerAdmin(Customer customer,String r);


}
