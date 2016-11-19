package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import configuration.MvcConfigure;
import dao.ProductDao;
import domain.Product;
import service.ProductService;

@Controller
public class Main {
	@Autowired
	ProductService productService;
	
//	public static void main(String args[]){
//		//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MvcConfigure.class);
//		Main m=new Main();
	Product p=new Product();
//		p.setDescription("this is product p");
		
	
	@RequestMapping("/prod")
	public String t()
	{
		return "product";
		
	}
	
}
