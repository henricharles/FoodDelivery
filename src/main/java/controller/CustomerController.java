package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Customer;
import service.CustomerService;

@Controller
@RequestMapping(value = "/Customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/Add", method = RequestMethod.GET)
	public String displayCustomerView(@ModelAttribute("newCustomer") Customer customer) {
		return "createCustomer";
	}

	@RequestMapping(value = "/Signup", method = RequestMethod.POST)
	public String createCustomer(@ModelAttribute("newCustomer") @Valid Customer customerToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "createCustomer";
		}
		customerService.createCustomer(customerToBeAdded,"ROLE_GUESS");
		
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String createMemebr()
	{
		return "member";  
	}
	@RequestMapping(value = "/add1", method = RequestMethod.POST)
	public String createCustomer(Customer customer) {
		customerService.createCustomer(customer,"ROLE_ADMIN");
		
		return "redirect:/welcome";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser(ModelMap model) {
		model.addAttribute("user", customerService);
		return "product";
	}
}

