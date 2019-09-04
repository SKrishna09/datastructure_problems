package com.practice.problems.strings;

public class NaiveSearch {

	/*
	 * Naive algorithm for Pattern Searching. The number of comparisons in the worst
	 * case is O(m*(m-n+1)) => O(mn)
	 */

	public static void main(String[] args) {
		String text = "AABAACAADAABAABA";
		String pattern = "AABA";
		naivePatternSearching(text, pattern);
		System.out.println("***** Optimized naive Pattern Searching *****");
		naivePatternSearchingOptimized(text, pattern);
	}

	public static void naivePatternSearching(String text, String pattern) {
		int m = text.length();
		int n = pattern.length();

		for (int i = 0; i <= (m - n); i++) {
			int j;
			for (j = 0; j < n; j++) {
				if (text.charAt(i + j) != pattern.charAt(j))
					break;
			}
			if (j == n)
				System.out.println("Pattern found at " + i);
		}
	}

	public static void naivePatternSearchingOptimized(String text, String pattern) {
		int m = text.length();
		int n = pattern.length();

		for (int i = 0; i <= (m - n); i++) {
			int j;
			for (j = 0; j < n; j++) {
				if (text.charAt(i + j) != pattern.charAt(j))
					break;
			}
			if (j == n)
				System.out.println("Pattern found at " + i);
			else if (j == 0)
				i = i + 1;
			else
				i = i + j;
		}
	}
}
