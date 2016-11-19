package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Category;
import domain.Store;

public interface CategoryDao extends JpaRepository<Category,Integer>{

}
