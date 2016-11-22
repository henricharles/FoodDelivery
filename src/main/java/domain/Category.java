package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Category {
	@Id @GeneratedValue
	private int id;
	
	@NotBlank(message="Name is required")
	@Size(min=6, max=50, message="Name must be between 6-50 characters.")
	private String name;
	
	@NotEmpty(message="File is required")
	@Lob
	private byte[] image;
	
	@OneToMany(mappedBy="category")
	private List<Product> product=new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", image=" + image + ", product=" + product + "]";
	}

	
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


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

}
