package com.practice.problems.designpattern.builder;

public class User {

	/*
	 * Builder pattern aims to Separate the construction of a complex object from
	 * its representation so that the same construction process can create different
	 * representations.
	 */

	private String firstName;
	private String lastName;
	private Integer age;
	private String phone;
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	private User(Userbuilder ub) {
		this.firstName = ub.firstName;
		this.lastName = ub.lastName;
		this.age = ub.age;
		this.phone = ub.phone;
		this.address = ub.address;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	/*
	 * Above created user object does not have any setter method, so it’s state can
	 * not be changed once it has been built. This provides the desired
	 * im-mutability.
	 */

	public static class Userbuilder {
		private String firstName;
		private String lastName;
		private Integer age;
		private String phone;
		private String address;

		public Userbuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Userbuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Userbuilder setAge(Integer age) {
			this.age = age;
			return this;
		}

		public Userbuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Userbuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
