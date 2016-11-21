package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Store {
	@Id @GeneratedValue
	private int id;
	private String name;
	@Embedded
	private Address address;
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="store")
	private List<Product> product;
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}	
