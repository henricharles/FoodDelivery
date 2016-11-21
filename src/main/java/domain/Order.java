package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Order_1")
public class Order {
	@Id @GeneratedValue
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private int amount;
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="order")
	private List<Product> product=new ArrayList<>();

	
	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Schedule schedule;
	
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
