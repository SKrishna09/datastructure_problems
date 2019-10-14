package com.practice.problems.designpattern.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public class CascadeAddressValidator implements Validator {

	private List<Validator> validatorList = new ArrayList<>();

	public CascadeAddressValidator(List<Validator> list) {
		validatorList = list;
	}

	@Override
	public boolean validate(Address a) {
		for (Validator v : validatorList) {
			if (!v.validate(a))
				return false;
		}
		return true;
	}

}
