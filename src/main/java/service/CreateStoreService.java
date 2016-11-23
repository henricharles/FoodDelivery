package service;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import domain.Customer;

public interface CreateStoreService {
	public String createCustomer(  Customer customerToBeAdded, BindingResult result);

}
