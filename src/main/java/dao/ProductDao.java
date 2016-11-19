package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	
}
