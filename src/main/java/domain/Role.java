package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	private String username;
	
  	@Column(name = "NAME", nullable = false)
 	private String name;
  	
	public Role() {
		super();
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
 	
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 
 	
}
