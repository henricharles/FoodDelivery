package controller;

import java.io.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import domain.Category;
import service.AdminService;
import service.CategoryService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

@Controller
public class CategoryController{

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/addCategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addCategory";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "Categories";
	}

	@Transactional
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public String addCategoryy(@Valid @ModelAttribute("category") Category category,  BindingResult result, ModelMap model, @RequestParam MultipartFile image) throws IOException{
		/*if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			return "addCategory";
			
		}*/
		System.out.println(category.getName()+"=========="+result.toString());
		if(image!=null)
			category.setImage(image.getBytes());
		categoryService.createCategory(category);
		return "redirect:/categories";
		
	}
	
	@Transactional
	@RequestMapping(value ="/images/{id}", method = RequestMethod.GET)
	public void getImageForProduct(Model model, @PathVariable("id") int id, HttpServletResponse response,HttpServletRequest request) 
	          throws ServletException, IOException {
		
		System.out.println("getting image");
		
		Category category = categoryService.find(id);
		System.out.println(category);
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    ServletOutputStream out = response.getOutputStream();
	    out.write(category.getImage());
	    out.close();
}
	
	
	/*public String add(HttpServletRequest request, HttpServletResponse response,Model model) {
		List<String> errors=new ArrayList<>();
		Category c = new Category();
		c.setName(request.getParameter("name"));
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
//						fieldName = fi.getFieldName().toString();
//						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						file = new File(filePath + fname);
						fi.write(file);
						// out.println("Uploaded Filename: " + filePath +
						// fileName + "<br>");
						
						c.setImage(fname);
						
					}
				}
				if(hs.get("categoryName")==null){
					errors.add("categoryName cannot be null");
				}
				if(fname==null){
					errors.add("image cannot be null");
				}
				model.addAttribute("error",errors);
				if(errors.isEmpty()){
					c.setName(hs.get("categoryName"));
					categoryService.createCategory(c);
				}
				
				else{
					return "addCategory";
				}
				

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		return "redirect:/categories";

		///////////////////////

	}*/

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String add(HttpServletRequest request) {
		DiskFileItemFactory d = new DiskFileItemFactory();
		ServletFileUpload uploader = new ServletFileUpload(d);
		return "redirect:/categories";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("category", categoryService.find(id));
		return "categoryDetail";
	}

	@RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
	public String update(Category category, @PathVariable int id) {
		categoryService.update(category); // car.id already set by binding
		System.out.println("update");
		return "redirect:/categories";
	}

	@RequestMapping(value = "/categories/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {
		categoryService.delete(id);
		System.out.println("deleted");
		return "redirect:/categories";
	}
	
}
