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
	
<<<<<<< HEAD
	@OneToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="USERNAME") 
	private User user;


	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Order> orders=new ArrayList<>();
=======
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<Order> orders=new ArrayList<>();*/
>>>>>>> ca1e78d7162da247f4434b59218061587647fbd6

	public Customer(){
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}