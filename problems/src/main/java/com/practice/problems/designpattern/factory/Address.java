package com.practice.problems.designpattern.factory;

import java.util.Arrays;

public class Address {

	private String[] addressline;
	private String city;
	private String state;
	private String country;
	private String zip;

	public String[] getAddressline() {
		return addressline;
	}

	public void setAddressline(String[] addressline) {
		this.addressline = addressline;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [addressline=" + Arrays.toString(addressline) + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zip=" + zip + "]";
	}
}
