package service;

import java.util.List;

import domain.Product;

public interface DeliveryPerson {
	public List<Product> getAllDeliveryPerson();
	public void saveDeliveryPerson(Product product);

}
