
package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Customer;

import domain.Store;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{
	Customer findByUsername(String userName);

	
//	public List<Customer> findAll();
//	List<Customer >findByEmail(String emailAddress);
//	List<Customer> findByFirstName(String email);
//	List<Customer> findByUserUsername(String username);
//	List<Customer> findByUserRolesName(String role);
//	//public void save(Customer cutomer);

	List<Customer> findByadressCity(String city);
	

}