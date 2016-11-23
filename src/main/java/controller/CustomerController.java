package controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	CustomerService customerService;

	@RequestMapping(value = "/Add", method = RequestMethod.GET)
	public String displayCustomerView(@ModelAttribute("newCustomer") Customer customer) {
		//model.addAttribute("customer", new Customer());
		return "createCustomer";
	}
@org.springframework.transaction.annotation.Transactional
	@RequestMapping(value = "/Signup", method = RequestMethod.POST)
	public String createCustomer( @Valid @ModelAttribute("newCustomer") Customer customerToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "createCustomer";
		}
		customerService.createCustomer(customerToBeAdded,"ROLE_GUESS");
		
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String createMemebr(Model model)
	{
		model.addAttribute("newMember", new Customer());
		return "member";  
	}
	@RequestMapping(value = "/add1", method = RequestMethod.POST)
	
	public String createMember(@ModelAttribute("newMember") @Valid Customer memberToBeAdded, BindingResult result1) {
		if(result1.hasErrors()) {
			return "member";
		}
		
		
		return "redirect:/welcome";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser(ModelMap model) {
		model.addAttribute("user", customerService);
		return "product";
	}
}

