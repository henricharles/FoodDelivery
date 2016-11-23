package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Category;
import domain.Customer;
import domain.Product;
import domain.Role;
import domain.User;
import service.CategoryService;
import service.CustomerService;
import service.ProductService;
import service.RoleService;
import service.UserService;

@RestController
@RequestMapping("/ressource")
public class RessourceController {
	@Autowired
	UserService userservice;
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	CategoryService categoryService;
	ProductService productservice;
	@Autowired 
	RoleService roleService;
	@RequestMapping("/allUser")
	public List<User> getUser()
	{
		return userservice.findAll();
	}
	@RequestMapping("/allrole")
	public List<Role> getAllproduct()
	{
		return roleService.getAllRole();
	}
	
	@RequestMapping("/allcategory")
	public List<Category> getAllcategory()
	{
		return categoryService.getAll();
	}
	
	@RequestMapping(value="/userByname/{name}")
	public List<User> findUserByuserName(@PathVariable String name){
	
		return userservice.userByName(name);
	}
	
	@RequestMapping(value="/onecustomer/{id}")
	public Customer findoneCustomer(@PathVariable int id){
	
		return customerservice.findOne(id);
}

	@RequestMapping(value="/onecategory/{id}")
	public Category userByCity(@PathVariable int id){
	
		return categoryService.find(id);
}
	
	@RequestMapping(value="/userbyAddress/{city}")
	public List<Customer> userByCity(@PathVariable String city){
	
		return customerservice.findCustomerByAddress(city);
}
	@RequestMapping("/authenticatedUser/{name}")
	public User findenabledUser(@PathVariable String name)
	{
		return userservice.getAunthenticateUser(name);
	}
	@RequestMapping(value="/deleteproduct/{id}", method = RequestMethod.DELETE)
	public void  productdelete(@PathVariable int id){
	
		productservice.DeleteProduct(id);
}
}
