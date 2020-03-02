package com.practice.problems.strings;

public class SmallestAndLargestSubstring {

	public static void main(String[] args) {
		String str = "welcometojava";
		int k = 3;
		getSmallestAndLargest(str, k);
	}

	public static void getSmallestAndLargest(String s, int k) {
		String currStr = s.substring(0, k);
		String lexMin = currStr;
		String lexMax = currStr;

		for (int i = k; i < s.length(); i++) {
			currStr = currStr.substring(1, k) + s.charAt(i);
			if (lexMax.compareTo(currStr) < 0)
				lexMax = currStr;
			if (lexMin.compareTo(currStr) > 0)
				lexMin = currStr;
		}
		
		System.out.println(lexMin);
		System.out.println(lexMax);
	}
}
