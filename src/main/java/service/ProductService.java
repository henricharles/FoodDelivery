package service;

import java.util.List;

import domain.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public void saveProduct(Product product);
	public Product GetSingleProduct(int id);
}
