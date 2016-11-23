package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.Order;
import domain.OrderStatus;
import domain.Product;
import service.CustomerService;
import service.OrderImpl;
import service.OrderService;
import service.ProductService;

@Controller
@SessionAttributes("shoppingList")
public class OrderController {

	@Autowired
	OrderService orderHandl;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Transactional
	@RequestMapping(value="productList/productDetail/order/{id}",method=RequestMethod.POST)
	public String order(@PathVariable int id, @ModelAttribute("shoppingList") List<Product> productList,Model model){
		Product p=productService.GetSingleProduct(id);
		List<Product> product=new ArrayList<>();
		product.add(p);
		System.out.println("==============="+product);
		product=productList;
		product.add(p);
		model.addAttribute("shoppingList",product);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/cart",method=RequestMethod.GET)
	public String showCart(@ModelAttribute("shoppingList") List<Product> productList,Model model){
		double total=0.0;
		List<Product> product=productList;
		for(Product p: product){
			total+=p.getPrice();
		}
		
		model.addAttribute("products", productList);
		model.addAttribute("totalamount", total);
		return "cart";
		
		
	}
	
	@RequestMapping(value="/orderSave",method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute("shoppingList") List<Product> productList,@RequestParam("totalAmount") double total){
		Order order=new Order();
		order.setProduct(productList);
		order.setOrderDate(new Date());
		order.setStatus(OrderStatus.INITIATED);
		orderHandl.save(order);
		return "redirect:/cart";
		
	}
	
	@Transactional
	@RequestMapping(value = "/OrderView/{CustomerID}", method = RequestMethod.GET)
	public String OrderView(@PathVariable("CustomerID") int CustId, ModelMap model) {
	
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