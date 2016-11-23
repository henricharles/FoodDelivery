package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Store;

public interface DeliveryPersonDao extends JpaRepository<Store,Integer>{

}