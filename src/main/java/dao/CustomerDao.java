package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Customer;
import domain.Store;

public interface CustomerDao extends JpaRepository<Customer,Integer>{

}