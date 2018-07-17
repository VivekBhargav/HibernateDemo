package com.hbrnt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders_products")
public class Orders_Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int orderProductID;
	private int orderId;

	@NotNull
	private int productID;
	private int quantity;
	private double price;

	public Orders_Products(int orderId, @NotNull int productID, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
	}

	public Orders_Products() {
	}

	public int getOrderProductID() {
		return orderProductID;
	}

	public void setOrderProductID(int orderProductID) {
		this.orderProductID = orderProductID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Orders_Products [orderProductID=" + orderProductID + ", orderId=" + orderId + ", productID=" + productID
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}

}
