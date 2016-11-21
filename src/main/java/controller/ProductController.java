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

		model.put("product", new Product());
		return "AddProducts";
	}

	@Transactional
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
	
	
	
	
		/*@RequestMapping(value = "/categories", method = RequestMethod.POST)
		public String add(HttpServletRequest request, HttpServletResponse response) {
			
			File file;
			int maxFileSize = 5000 * 1024;
			int maxMemSize = 5000 * 1024;
			String filePath = "C:/Users/manoj/Desktop/deployed app/foodDelivery/images/";

			String contentType = request.getContentType();
			String fieldName = null;
			String fname = "";
			if ((contentType.indexOf("multipart/form-data") >= 0)) {

				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(maxMemSize);
				// factory.setRepository(new File("c:\\temp"));
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(maxFileSize);

				Hashtable< String, String> hs = new Hashtable<>();
				
				try {
					List fileItems = upload.parseRequest(request);
					Iterator i = fileItems.iterator();
					while (i.hasNext()) {
						//System.out.println(FileItem(i.next()));
						FileItem fi = (FileItem) i.next();
						//System.out.println(fi.getFieldName()+"---"+fi.getString());
						hs.put(fi.getFieldName(), fi.getString());
						System.out.println(fi.getName());
						if (!fi.isFormField()) {
							fieldName = null;
							fname = FilenameUtils.getName(fi.getName());
//							fieldName = fi.getFieldName().toString();
//							String fileName = fi.getName();
							boolean isInMemory = fi.isInMemory();
							long sizeInBytes = fi.getSize();
							file = new File(filePath + fname);
							fi.write(file);
							// out.println("Uploaded Filename: " + filePath +
							// fileName + "<br>");
							
							c.setImage(fname);
							
						}
					}
					c.setName(hs.get("categoryName"));
					categoryService.createCategory(c);

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			return "redirect:/categories";
	}*/

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		
		List<Category> catList = new ArrayList<Category>();
		catList = prodHand.GetCategory();
		
		return catList;
	}
	
}
