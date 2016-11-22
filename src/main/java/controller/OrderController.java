package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	
	@Transactional
	@RequestMapping(value = "/OrderView/{CustomerID}", method = RequestMethod.GET)
	public String PageLoad(@PathVariable("CustomerID") int CustId, ModelMap model) {
	
		List<Order> OrderList = orderHandl.getOrderByID(1);
		int totalAmount = 0;
		for(Order o: OrderList){
			totalAmount += o.getAmount();
		}
		model.addAttribute("order", OrderList);
		model.addAttribute("TotalOrderAmt", totalAmount);
		return "OrderView";
	}
}
