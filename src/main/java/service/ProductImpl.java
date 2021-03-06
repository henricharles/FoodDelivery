
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CategoryDao;
import dao.ProductDao;
import domain.Category;
import domain.Product;

@Service
public class ProductImpl implements ProductService{
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao CatDAO;
	
	@Override
	public List<Product> getAllProduct() {
		return productDao.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		productDao.save(product);
	}
	
	public void DeleteProduct(int id){
		try{
			productDao.delete(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void AddProduct(Product p){
		productDao.save(p);
	}
	
	/*public void UploadFile(UploadItem uploadItem){
		
	}*/
	public Product GetSingleProduct(int id){
		return productDao.findOne(id);
	}
	
	public void UpdateProduct(Product p){
		productDao.save(p);
	}
	public List<Category> GetCategory(){
		return CatDAO.findAll();		
	}

	public Category GetCategoryById(int id) {
		return CatDAO.findOne(id);
	}
}
