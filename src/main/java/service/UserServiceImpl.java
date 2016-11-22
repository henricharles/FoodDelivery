package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import domain.User;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	
 	@Autowired
	private UserDao userDao;

//  	@PreAuthorize("hasRole('ROLE_ADMIN')")
  	public User save(User user) {
  		
  		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 		
  		String encodedPassword = passwordEncoder.encode(user.getPassword());
  		user.setPassword(encodedPassword);
  		
  		return userDao.save(user);
	}
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}
 
}
