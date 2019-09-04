package com.practice.problems.strings;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		String A = "444444444444444444444444";
		String B = "4444444444444444444444444";
		int ans = compareVersion(A, B);
		System.out.println(ans);
	}

	public static int compareVersion(String A, String B) {
		int version = 0;
		String[] A1 = A.split("\\.");
		String[] B1 = B.split("\\.");

		int i = 0;
		int j = 0;
		
		while(i <= j) {
			
		}
		
		if (a1 > b1) {
			version = 1;
		} else if (a1 < b1) {
			version = -1;
		} else {
			version = 0;
		}
		return version;
	}

}
