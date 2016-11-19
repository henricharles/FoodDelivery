package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Store;

public interface CategoryDao extends JpaRepository<Store,Integer>{

}
