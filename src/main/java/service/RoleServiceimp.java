package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoleDao;
import domain.Role;
@Service
public class RoleServiceimp implements RoleService{
@Autowired
RoleDao roledao;
	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roledao.findAll();
	}

}
