package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import domain.Category;
import domain.Store;

public interface CategoryDao extends JpaRepository<Category,Integer>{
	//public void update(@Param("name")String name,@Param("id") int id);
	
}

