package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DeliveryPersonDao;
import dao.ProductDao;
import domain.Product;


@Service
public class DeliveryPersonImpl implements DeliveryPerson{
	@Autowired
	private DeliveryPersonDao productDao;

	@Override
	public List<Product> getAllDeliveryPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveDeliveryPerson(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	

}
