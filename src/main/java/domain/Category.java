package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

@Entity
public class Category {
	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	private String image;
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="category")
	private List<Product> product=new ArrayList<>();
	public String getImage() {
		return image;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", image=" + image + ", product=" + product + "]";
	}

	public void setImage(String image) {
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
