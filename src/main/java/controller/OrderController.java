package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.Order;
import domain.Product;
import service.OrderImpl;

@Controller
public class OrderController {

	@Autowired
	OrderImpl orderHandl = new OrderImpl();
	
	@RequestMapping(value = "/OrderView/{CustomerID}", method = RequestMethod.GET)
	public String PageLoad(@PathVariable("CustomerID") int CustId, ModelMap model) {
		
		model.addAttribute("order", orderHandl.getOrderByID(CustId));
		return "OrderView";
	}
}
