package com.practice.problems.strings;

import java.util.Arrays;

public class Anagram {

	static int NO_OF_CHARS = 256;

	public static void main(String[] args) {

		String a = "Hello";
		String b = "hello";
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}

	static boolean isAnagram(String a, String b) {
		boolean isAnagarm = true;
		int[] count = new int[NO_OF_CHARS];
		Arrays.fill(count, 0);

		char[] s1 = a.toLowerCase().toCharArray();
		char[] s2 = b.toLowerCase().toCharArray();

		if (s1.length != s2.length) {
			isAnagarm = false;
			return isAnagarm;
		}

		for (int i = 0; i < s1.length; i++) {
			count[s1[i]]++;
			count[s2[i]]--;
		}

		for (int j = 0; j < NO_OF_CHARS; j++) {
			if (count[j] > 0) {
				isAnagarm = false;
				return isAnagarm;
			}
		}
		return isAnagarm;
	}
}
