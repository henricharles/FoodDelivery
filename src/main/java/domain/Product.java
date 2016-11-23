
package domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Product {
	@Id @GeneratedValue
	private int id;
	
	@NotBlank(message="Name is required")
	@Size(min=6, max=50, message="Name must be between 4-50 characters.")
	private String name;
	
	@Min(1)
	@NumberFormat(style= Style.NUMBER)
	private double price;
	
	@NotBlank(message="Description is required.")
	private String description;
	
	@Lob
	private byte[] photo;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Store store;
	
	//@NotBlank(message="Category is required.")
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Category category;
	
	@ManyToOne
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
