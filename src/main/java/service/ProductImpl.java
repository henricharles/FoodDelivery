package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import domain.Product;


@Service
public class ProductImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProduct() {
		return productDao.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		productDao.save(product);
	}
	
	

}
