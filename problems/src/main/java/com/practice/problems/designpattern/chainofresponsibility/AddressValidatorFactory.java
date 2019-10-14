package com.practice.problems.designpattern.chainofresponsibility;

import java.util.Arrays;
import java.util.HashMap;

public class AddressValidatorFactory {

	private static AddressValidatorFactory factory = null;

	private static HashMap<String, Validator> validator = new HashMap<>();

	private AddressValidatorFactory() {
		validator.put("payments", new CascadeAddressValidator(Arrays.asList(new ZipValidator(), new CityValidator())));
		validator.put("notification",
				new CascadeAddressValidator(Arrays.asList(new ZipValidator(), new CityValidator(),new CountryValidator())));
	}

	public static AddressValidatorFactory getInstance() {
		if (null == factory)
			factory = new AddressValidatorFactory();
		return factory;
	}

	public Validator getValidator(String name) {
		if (validator.containsKey(name))
			return validator.get(name);
		return null;
	}

}
