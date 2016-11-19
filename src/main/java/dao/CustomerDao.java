package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Store;

public interface CustomerDao extends JpaRepository<Store,Integer>{

}