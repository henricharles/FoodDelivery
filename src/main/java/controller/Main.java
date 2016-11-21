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

import configuration.MvcConfigure;
import dao.ProductDao;
import domain.Address;
import domain.Product;
import domain.Store;
import service.AdminService;
import service.CategoryService;
import service.ProductService;

@Controller
public class Main {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AdminService adminService;
//	public static void main(String args[]){
//		//AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MvcConfigure.class);
//		Main m=new Main();
	
//		p.setDescription("this is product p");
		
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
	
	
}
