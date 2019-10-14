package com.practice.problems.designpattern.factory;

import java.util.HashMap;

public class AddressValidatorFactory {

	private static AddressValidatorFactory validator;

	private HashMap<String, AddressValidator> addressValidator = new HashMap<>();

	private AddressValidatorFactory() {
		addressValidator.put("india", new IndiaAddressValidator());
		addressValidator.put("usa", new USAAddressValidator());
	}

	public static AddressValidatorFactory getValidator() {
		if (null == validator)
			validator = new AddressValidatorFactory();
		return validator;
	}

	public AddressValidator addressValidator(String countryName) {
		if (addressValidator.containsKey(countryName)) {
			return addressValidator.get(countryName);
		}
		return null;
	}
}
