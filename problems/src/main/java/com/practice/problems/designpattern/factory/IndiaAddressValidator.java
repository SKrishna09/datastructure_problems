package com.practice.problems.designpattern.factory;

public class IndiaAddressValidator implements AddressValidator {

	@Override
	public boolean validateAddress(Address a) {
		System.out.println("INDIA Address Validator:::");
		return true;
	}

}
