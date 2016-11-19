package domain;

import javax.persistence.*;
@Entity
public class Product {
	@Id @GeneratedValue
	private int id;
	private String name;
	private double price;
	
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Store store;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Order order;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Lob
	private byte[] photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
