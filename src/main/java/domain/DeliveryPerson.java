package domain;

import javax.persistence.*;

@Entity
public class DeliveryPerson extends Person{
	private String area;
	private boolean availability;
	@OneToOne(cascade=CascadeType.ALL)
	private Schedule schedule;
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
