package com.practice.problems.designpattern.factory;

public class ClientAddressValidator {

	public static void main(String[] args) {
		Address a1 = new Address();
		a1.setCountry("India");
		a1.setState("Karnataka");
		a1.setCity("Bangalore");
		validateAddress(a1);

		Address a2 = new Address();
		a2.setCountry("Usa");
		a2.setState("Karnataka");
		a2.setCity("Bangalore");
		validateAddress(a2);

		Address a3 = new Address();
		a3.setCountry("Australia");
		a3.setState("Karnataka");
		a3.setCity("Bangalore");
		validateAddress(a3);
	}

	public static void validateAddress(Address a) {
		AddressValidator validator = AddressValidatorFactory.getValidator()
				.addressValidator(a.getCountry().toLowerCase());
		if (null == validator) {
			System.out.println("Invalid Country");
		} else {
			boolean isValid = validator.validateAddress(a);
			if (isValid)
				System.out.println("Valid Address");
			else
				System.out.println("Invalid Address");
		}
	}

}
