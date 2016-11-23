package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;
import domain.User;

public interface UserService {
	
	public User getAunthenticateUser(String userName);
	public User   save(User u);
	public List<User> findAll();
	public List<User> userByName(String name);
}
