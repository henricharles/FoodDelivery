package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import dao.StoreDao;
import domain.Product;
import domain.Store;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private StoreDao storeDao;
	

	@Override
	public void createStore(Store store) {
		// TODO Auto-generated method stub
		storeDao.save(store);
	}


	@Override
	public void scheduledelivery() {
		// TODO Auto-generated method stub
		
	}
		


}
