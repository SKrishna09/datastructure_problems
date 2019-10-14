package com.practice.problems.designpattern.factory;

public class USAAddressValidator implements AddressValidator {

	@Override
	public boolean validateAddress(Address a) {
		System.out.println("USA Address Validator");
		return false;
	}

}
