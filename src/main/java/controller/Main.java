package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import configuration.MvcConfigure;
import dao.ProductDao;
import domain.Address;
import domain.Product;
import domain.Store;
import service.AdminService;
import service.ProductService;
@Controller
public class Main {
	@Autowired
	ProductService productService;
	
	@Autowired
	AdminService adminService;
//	public static void main(String args[]){
//		//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MvcConfigure.class);
//		Main m=new Main();
	
//		p.setDescription("this is product p");
		
	
	@RequestMapping("/home")
	@ResponseBody
	public String t()
	{	Store s=new Store();
		Product p=new Product();
		p.setName("biscuit");
		p.setPrice(300.33);
		Product p1=new Product();
		p.setName("soap");
		p.setPrice(300.33);
		List<Product> products=new ArrayList<>();
		p.setStore(s);
		products.add(p);
		products.add(p1);
		s.setProduct(products);
		adminService.createStore(s);
		return "hellooooo";
		
	}
	
}
