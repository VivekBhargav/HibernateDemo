package com.hbrnt.pojo;

public class ReportBean {
	private int CustomerId;
	private String CustomerName;
	private int quantity;
	private double price;
	private double result;

	public ReportBean() {
	}

	public ReportBean(int customerId, String customerName, int quantity, double price) {
		super();
		this.CustomerId = customerId;
		this.CustomerName = customerName;
		this.quantity = quantity;
		this.price = price;
		this.result = quantity * price;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
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

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ReportBean [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", result=" + result + "]";
	}

}
