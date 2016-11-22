package dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
