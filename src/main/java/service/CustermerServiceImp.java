package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import domain.Customer;
import domain.Role;
import domain.User;

@Service
@Transactional
public class CustermerServiceImp implements CustomerService {
	
	@Autowired
	private UserService userService;

	@Autowired
	CustomerDao customerdao;

	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void createCustomer(Customer customer,String r) {
		User user = customer.getUser();
		List<Role> roles = new ArrayList<>();
		roles.add(new Role(r));
		user.setRoles(roles);
		user = userService.save(user);
		customer.setUser(user);
		customerdao.save(customer);
	}
	@Transactional
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void createCustomerAdmin(Customer customer,String r) {
		User user = customer.getUser();
		List<Role> roles = new ArrayList<>();
		roles.add(new Role(r));
		user.setRoles(roles);
		user = userService.save(user);
		customer.setUser(user);
		customerdao.save(customer);
	}
	public List<Customer> getAllCustomer()
	{
		return customerdao.findAll();
	}
	

	public List<Customer> findCustomerByAddress(String city)
	 {
		 return customerdao.findByadressCity(city);
	 }
	
	@Override
	public Customer findOne(int id) {
		// TODO Auto-generated method stub
		return customerdao.findOne(id);
	}
}
