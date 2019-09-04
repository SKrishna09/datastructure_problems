package com.practice.problems.strings;

public class KMPSearch {

	/*
	 * KMP (Knuth Morris Pratt) Pattern Searching. The number of comparisons in the
	 * worst case is O(m)
	 */

	public static void main(String[] args) {
		String text = "AABAACAADAABAABA";
		String pattern = "AABA";
	}

	public static void kmpPatternSearching(String text, String pattern) {
		int m = text.length();
		int n = pattern.length();
		int[] lps = new int[n];

		preProcessLPS(pattern, lps);
	}

	private static void preProcessLPS(String P, int[] lps) {
		int length = 0;
		int i = 0;
		char[] pattern = P.toCharArray();
		while(i < P.length()) {
			
		}
	}

}
