package com.practice.problems.designpattern.chainofresponsibility;

public class StateValidator implements Validator{

	@Override
	public boolean validate(Address a) {
		System.out.println("State Validator");
		if (null != a.getState())
			return true;
		return false;
	}

}
