package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer>{

}