package com.practice.problems.strings;

public class PalindromeString {

	public static void main(String args[]) {
		System.out.println("String aabaa is palindrome ? :" + isPalindrome("aabaa"));
		System.out.println("String abccba is palindrome ? :" + isPalindrome("abccba"));
		System.out.println("String abcxycba is palindrome ? :" + isPalindrome("abcxycba"));

	}

	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}

}
