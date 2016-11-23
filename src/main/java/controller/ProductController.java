
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import domain.Category;
import domain.Product;

import service.CustomerService;
import service.ProductService;

import service.ProductImpl;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
public class ProductController {

	@Autowired
	private ProductService prodHand;

	String val = "";

	@Autowired
	private CustomerService customer1;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
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
		Product P = prodHand.GetSingleProduct(id);
		model.put("product", P);
		return "AddProducts";
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String OpenAddProduct(ModelMap model) {

		val = "Add";
		model.addAttribute("Val", val);
	    model.addAttribute("categories", getCategories());

		model.addAttribute("product", new Product());
		return "AddProducts";
	}

	@Transactional
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public String AddProduct(@Valid @ModelAttribute("product") Product p,  BindingResult result, ModelMap model, @RequestParam MultipartFile productImage) throws IOException {
		
		if(result.hasErrors()){
			val = "Add";
			model.addAttribute("Val", val);
		    model.addAttribute("categories", getCategories());
			
			return "AddProducts";
		}
		else{
			if (val.equals("Add")) {
				if (productImage != null)
					p.setPhoto(productImage.getBytes());

				p.setCategory(prodHand.GetCategoryById(p.getCategory().getId()));
				prodHand.AddProduct(p);
				System.out.println(p.getPhoto());
			} else {
				prodHand.UpdateProduct(p);
			}
		}
		model.addAttribute("product", prodHand.getAllProduct());
		return "product";
		
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		List<Category> catList = new ArrayList<Category>();
		catList = prodHand.GetCategory();
		return catList;
	}

	@RequestMapping(value = "/createStore")
	public String displayStore() {
		return "addStore";
	}
	
	@Transactional
	@RequestMapping(value = "/image/{productId}", method = RequestMethod.GET)
	public void getImageForProduct(Model model, @PathVariable("productId") int productId, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException {
		
		System.out.println("getting image");
		
		Product product = prodHand.GetSingleProduct(productId);
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    ServletOutputStream out = response.getOutputStream();
	    out.write(product.getPhoto());
	    out.close();
}
	
}
