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
/*@RequestMapping("/admin")
*/public class adminController{

	@RequestMapping("/admin")
	public String homePage(Model model)
	{	
		return "admin";
	}
	
}
