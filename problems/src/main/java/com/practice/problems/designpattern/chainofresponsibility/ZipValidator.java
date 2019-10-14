package com.practice.problems.designpattern.chainofresponsibility;

public class ZipValidator implements Validator {

	@Override
	public boolean validate(Address a) {
		System.out.println("Zip Validator");
		if (null != a.getZip())
			return true;
		return false;
	}

}
