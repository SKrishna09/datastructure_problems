package com.practice.problems.designpattern.builder;

public class UserGenerator {

	public static void main(String[] args) {

		User user1 = new User.Userbuilder().setFirstName("Krishnaa").setLastName("Shah").setAge(27)
				.setAddress("Bangalore").build();
		System.out.println("User Created::" + user1);

		User user2 = new User.Userbuilder().setFirstName("Krishnaa").setLastName("Shah").setAddress("Ahmedabad")
				.build();
		System.out.println("User Created::" + user2);
	}
}
