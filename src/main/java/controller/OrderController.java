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

import domain.Customer;
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
	@Transactional
	@RequestMapping(value="/orderSave",method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute("shoppingList") List<Product> productList,@ModelAttribute("user") Customer customer,@RequestParam("totalAmount") double total){
		Order order=new Order();
		order.setProduct(productList);
		order.setOrderDate(new Date());
		order.setStatus(OrderStatus.INITIATED);
		order.setAmount(total);
		orderHandl.save(order);
		
		System.out.println("inside saveOrder"+"\n"+order);
		/*Customer cust=customerService.findByUsername(customer.getUsername());
		System.out.println(cust.getPerson_Id());
		//order.setCustomer(cust);
		List<Order> orders=new ArrayList<Order>();
		orders.add(order);
		//orderHandl.save(order);
		System.out.println(orders);
		//cust.setOrders(orders);
		//customerService.save(cust);
*/		return "redirect:/cart";
		
	}
	
	@Transactional
	@RequestMapping(value = "/OrderView/{CustomerID}", method = RequestMethod.GET)
	public String OrderView(@PathVariable("CustomerID") String userName, ModelMap model) {
	
		List<Order> OrderList = orderHandl.getOrderByUserName(userName);
		int totalAmount = 0;
		for(Order o: OrderList){
			totalAmount += o.getAmount();
		}
		model.addAttribute("order", OrderList);
		model.addAttribute("TotalOrderAmt", totalAmount);
		
		return "OrderView";
	}
	
	
}