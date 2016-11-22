package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Order;

public interface OrderDao extends JpaRepository<Order,Integer>{

	public List<Order> findBycustomer(int id);
}