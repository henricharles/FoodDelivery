
package domain;

import java.sql.Blob;

import javax.persistence.*;
@Entity
public class Product {
	@Id @GeneratedValue
	private int id;
	private String name;
	private double price;
	@Lob
	private Blob photo;
	
	private String description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Store store;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
