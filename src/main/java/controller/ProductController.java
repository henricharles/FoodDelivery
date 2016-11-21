package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import domain.Category;
import domain.Product;
import service.ProductImpl;

import org.springframework.ui.ModelMap;

@Controller
public class ProductController {

	@Autowired
	private ProductImpl prodHand;
	String val = ""; 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String PageLoad(ModelMap model) {
		model.addAttribute("product", prodHand.getAllProduct());
		return "product";
	}

	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public String DeleteProduct(@RequestParam("productNumber") int id, ModelMap model) {

		prodHand.DeleteProduct(id);
		model.addAttribute("product", prodHand.getAllProduct());
		return "product";
	}

	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public String UpdateProduct(@RequestParam("productNumber") int id, ModelMap model) {

		val = "Update";
		model.addAttribute("Val", val);

		Product P = prodHand.GetSingleProduct(id);
		model.put("product", P);

		return "AddProducts";
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String OpenAddProduct(ModelMap model) {

		val = "Add";
		model.addAttribute("Val", val);
	    model.addAttribute("categories", getCategories());
		

		model.put("product", new Product());
		return "AddProducts";
	}

	
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public String AddProduct(Product p, ModelMap model) {
		if (val.equals("Add")) {
			p.setCategory(prodHand.GetCategoryById(p.getCategory().getId()));
			prodHand.AddProduct(p);
		}
		else{ 	
			prodHand.UpdateProduct(p);
		}
		model.addAttribute("product", prodHand.getAllProduct());
		return "product";
	}
	
	@Transactional
	//@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		List<Category> catList = new ArrayList<Category>();
		catList = prodHand.GetCategory();
		return catList;
	}
	
}
