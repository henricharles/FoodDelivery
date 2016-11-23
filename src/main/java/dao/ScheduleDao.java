package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Store;

public interface ScheduleDao extends JpaRepository<Store,Integer>{

}