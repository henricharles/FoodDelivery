package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Role;

public interface RoleDao extends JpaRepository<Role,Integer>{

}
