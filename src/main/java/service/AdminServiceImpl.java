package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import dao.ScheduleDao;
import dao.StoreDao;
import domain.Product;
import domain.Store;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private StoreDao storeDao;
	//creating a Schelude Object for delivery
	@Autowired
	private ScheduleDao scheludedao;
	
	

	@Override
	public void createStore(Store store) {
		// TODO Auto-generated method stub
		storeDao.save(store);
	}


	@Override
	public void scheduledelivery() {
		// TODO Auto-generated method stub         
		//scheludedao.save(arg0)
		
		
	}
		


}
