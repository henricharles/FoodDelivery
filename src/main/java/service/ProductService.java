package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Category;
import domain.Product;


public interface ProductService {
	public List<Product> getAllProduct();
	public Product GetSingleProduct(int id);
	public void saveProduct(Product product);
	public void DeleteProduct(int id);
	public void AddProduct(Product p);
	public void UpdateProduct(Product p);
	public Category GetCategoryById(int id);
	public List<Category> GetCategory();
}
