package com.practice.problems.designpattern.chainofresponsibility;

public class CountryValidator implements Validator {

	@Override
	public boolean validate(Address a) {
		System.out.println("Country Validator");
		if (null != a.getCountry())
			return true;
		return false;
	}

}
