package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import configuration.MvcConfigure;
import dao.ProductDao;
import domain.Address;
import domain.Product;
import domain.Store;
import service.AdminService;
import service.CategoryService;
import service.CustomerService;
import service.OrderService;
import service.ProductService;

@Controller
@SessionAttributes("shoppingList")
public class MainController{
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	OrderService orderService;
	
	@Transactional
	@RequestMapping(value={"/"})
	public String home(Model model)
	{	
		if(!model.containsAttribute("order")) {
	      model.addAttribute("shoppingList", new ArrayList<Product>());
	    }
		model.addAttribute("categories",categoryService.getAll());
		System.out.println(categoryService.getAll().get(0).getProduct());
		return "index";
	}
		
	@Transactional
	@RequestMapping("/index")
	public String homePage(Model model)
	{	
		model.addAttribute("categories",categoryService.getAll());
		System.out.println(categoryService.getAll().get(0).getProduct());
		return "index";
	}
	
	@Transactional
	@RequestMapping(value="/productList/{id}",method=RequestMethod.GET)
	public String productPage(@PathVariable int id,Model model){
		System.out.println("productPage");
		model.addAttribute("products",categoryService.find(id).getProduct());
		System.out.println(categoryService.find(id).getProduct());
		return "productView";
	}
	
	@Transactional
	@RequestMapping(value="productList/productDetail/{id}",method=RequestMethod.GET)
	public String productDetail(@PathVariable int id,Model model){
		System.out.println("productDetail");
		model.addAttribute("product",productService.GetSingleProduct(id));
		System.out.println(productService.GetSingleProduct(id));
		return "productDetail";
	}
	
}
