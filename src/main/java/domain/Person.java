package domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int person_Id;
	
	private long phone;
	@Email(message="check your email Id")
	private String email;
	
	@NotBlank(message=" first name should not be empty")
	private String firstName;
	
	@NotBlank(message=" Last name should not be empty")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Embedded
	private Address adress;

	public Person(){
		
	}

	public int getPerson_Id() {
		return person_Id;
	}

	public void setPerson_Id(int person_Id) {
		this.person_Id = person_Id;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

}
