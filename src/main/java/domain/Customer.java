package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends Person {
	
	@OneToMany(mappedBy="customer")
	private List<Order> orders=new ArrayList<>();

	@OneToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="USERNAME") 
	private User user;


	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Order> orders=new ArrayList<>();*/


	public Customer(){
		
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getUsername() {
		return username;

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}