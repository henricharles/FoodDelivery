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
	
	/*public ProductHandler(){
		Plist = new ArrayList<Product>();
		Plist.add(new Product(1,"tomato","red tomato",34));
		Plist.add(new Product(2,"Lintel","cereals",6));
		Plist.add(new Product(3,"Banana","fruits",4));
	}
	
	public ArrayList<Product> GetProduct(){
		return Plist;
	}*/
	
	public void DeleteProduct(int id){
		productDao.delete(id);
		/*for(int i =0; i< Plist.size(); i++){
			if(Plist.get(i).getId() == id)
				Plist.remove(i);		
		}*/
	}
	
	public void AddProduct(Product p){
		productDao.save(p);
		//Plist.add(p);
	}
	
	public void GetSingleProduct(int id){
		productDao.findOne(id);
		/*for(int i =0; i< Plist.size(); i++){
			if(Plist.get(i).getId() == id)
				return Plist.get(i);		
		}
		return null;*/
	}
	
	public void UpdateProduct(Product p){
		productDao.save(p);
		/*for(int i =0; i< Plist.size(); i++){
			Product pro = Plist.get(i);
			if(pro.getId() == p.getId()){
				pro.setName(p.getName());
				pro.setDescription(p.getDescription());
				pro.setPrice(p.getPrice());
				pro.setCategory(p.getCategory());
			}
		}*/
	}
	

}
