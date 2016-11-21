package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Category {
	@Id @GeneratedValue
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="category")
	private List<Product> product=new ArrayList<>();
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
