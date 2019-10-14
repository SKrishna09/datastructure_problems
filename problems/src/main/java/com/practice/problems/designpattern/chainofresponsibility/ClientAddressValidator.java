package com.practice.problems.designpattern.chainofresponsibility;

public class ClientAddressValidator {

	public static void main(String[] args) {
		Address a1 = new Address();
		a1.setCountry("India");
		a1.setState("Karnataka");
		a1.setCity("Bangalore");
		a1.setZip("5600102");
		validateAddress(a1, "payments");

		Address a2 = new Address();
		a2.setState("Karnataka");
		a2.setCity("Bangalore");
		a2.setZip("5600102");
		validateAddress(a2, "notification");

		Address a3 = new Address();
		a3.setCountry("Australia");
		a3.setState("Karnataka");
		a3.setCity("Bangalore");
		validateAddress(a3, "it");
	}

	public static void validateAddress(Address a, String type) {
		Validator validator = AddressValidatorFactory.getInstance().getValidator(type.toLowerCase());
		if (null == validator) {
			System.out.println("Invalid Request for " + type);
		} else {
			boolean isValid = validator.validate(a);
			if (isValid)
				System.out.println("Valid Address");
			else
				System.out.println("Invalid Address");
		}
	}
}
