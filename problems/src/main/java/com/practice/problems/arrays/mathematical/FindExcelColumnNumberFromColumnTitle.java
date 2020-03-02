package com.practice.problems.arrays.mathematical;

public class FindExcelColumnNumberFromColumnTitle {

	public static void main(String[] args) {
		String s = "AAA";
		int ans = titleToNumber(s);
		System.out.println("ExcelColumnNumberFromColumnTitle:::" + s + "::" + ans);
	}

	public static int titleToNumber(String title) {
		int result = 0;
		for (int i = 0; i < title.length(); i++) {
			result *= 26;
			result += title.charAt(i) - 'A' + 1;
		}
		return result;
	}
}
