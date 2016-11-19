package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Store;

public interface OrderDao extends JpaRepository<Store,Integer>{

}