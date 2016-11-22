package service;

import java.util.List;

import domain.Product;
import domain.Schedule;

public interface DeliveryPersonService {
	public List<Product> getAllDeliveryPerson();
	public void saveDeliveryPerson(Product product);
	public boolean isAvalaible(int id);
	public void  makeSchedule();
	

}
