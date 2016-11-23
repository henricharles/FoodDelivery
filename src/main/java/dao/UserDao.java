package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	public List<User>findByUsername(String userName);
}
