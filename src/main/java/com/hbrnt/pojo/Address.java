package com.hbrnt.pojo;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String streetNo;
	private String streetName;
	private String city;
	private String zip;
	
	public Address() {}
	
	public Address(String streetNo, String streetName, String city, String zip) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.city = city;
		this.zip = zip;
	}
	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
