package domain;

import javax.persistence.*;

@Entity
public class DeleveryPerson extends Person{
	private String area;
	private boolean availability;
	public String getArea() {
		return area;
	}
	public void setZip(String zip) {
		this.area = zip;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
}	
