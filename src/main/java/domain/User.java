package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "USERS")
public class User {

	@Id
	@Column(name = "USERNAME", nullable = false, unique = true)
	@NotNull
	private String username;
	
	@NotBlank(message="enter atlist 8 chararater")
	@Size(min=8,message="enter atlist 8 chararater")
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	private String verifyPassword;
	private Boolean enabled = true;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
	private List<Role> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}
	public User()
	{
		
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
