package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Customer extends Person {
	private String username;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Order> orders=new ArrayList<>();

	public Customer(){
		
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}





}