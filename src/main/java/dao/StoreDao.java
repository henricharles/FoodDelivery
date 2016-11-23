package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Store;

public interface StoreDao extends JpaRepository<Store,Integer>{
	
}
