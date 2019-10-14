package com.practice.problems.designpattern.chainofresponsibility;

public class CityValidator implements Validator {

	@Override
	public boolean validate(Address a) {
		System.out.println("City Validator");
		if (null != a.getCity())
			return true;
		return false;
	}

}
