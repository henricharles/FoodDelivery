package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Schedule {
	@Id @GeneratedValue
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String area;
	
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="schedule")
	private List<Order> order=new ArrayList<>();*/
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="schedule")
	private DeliveryPerson deliveryPerson;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
