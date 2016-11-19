package domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Order {
	@Id @GeneratedValue
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private int amount;
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
