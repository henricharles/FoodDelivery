package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Product;
import service.CustomerService;
import service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService prodHand;

	String val = "";

	@Autowired
	private CustomerService customer1;

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

		prodHand.GetSingleProduct(id);
		// model.put("product", P);

		return "AddProducts";
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String OpenAddProduct(ModelMap model) {

		val = "Add";
		model.addAttribute("Val", val);

		model.put("product", new Product());
		return "AddProducts";
	}

	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	// here, we get object of Product because we have used CommandName in jsp
	public String AddProduct(Product p, ModelMap model) {

		if (val.equals("Add")) {
			prodHand.AddProduct(p);
		} else {
			prodHand.UpdateProduct(p);
		}
		model.addAttribute("product", prodHand.getAllProduct());
		return "product";
	}

	@ModelAttribute("categories")
	public List<String> getCategories() {
		List<String> catList = new ArrayList<String>();
		catList.add("Vegetables");
		catList.add("Fruits");
		catList.add("Cereals");
		catList.add("Local Product");
		return catList;
	}

	@RequestMapping(value = "/createStore")
	public String displayStore() {
		return "addStore";
	}

}
