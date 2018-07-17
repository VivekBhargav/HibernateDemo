package com.hbrnt.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int order_ID;

	@Column(name = "custom_message")
	private String message;

	@Column(name = "invoice_cretation_date")
	private Date invDate;

	@Column(name = "delivery_due_date")
	private Date delDate;

	@Column(name = "payment_due_date")
	private Date payDate;

	private int custId;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private Set<Orders_Products> ordProducts;

	public Orders() {}
	public Orders(String message, Date invDate, Date delDate, Date payDate, int custId) {
		super();
		this.message = message;
		this.invDate = invDate;
		this.delDate = delDate;
		this.payDate = payDate;
		this.custId = custId;
	}

	public int getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Set<Orders_Products> getOrdProducts() {
		return ordProducts;
	}

	public void setOrdProducts(Set<Orders_Products> ordProducts) {
		this.ordProducts = ordProducts;
	}
	@Override
	public String toString() {
		return "Orders [order_ID=" + order_ID + ", message=" + message + ", invDate=" + invDate + ", delDate=" + delDate
				+ ", payDate=" + payDate + ", custId=" + custId + ", ordProducts=" + ordProducts + "]";
	}

}
