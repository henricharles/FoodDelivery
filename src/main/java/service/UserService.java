package service;

import java.util.List;

import domain.User;

public interface UserService {

	public User save(User user);

	public List<User> findAll();
}
