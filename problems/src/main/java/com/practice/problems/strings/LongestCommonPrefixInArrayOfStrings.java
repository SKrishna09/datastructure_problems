package com.practice.problems.strings;

public class LongestCommonPrefixInArrayOfStrings {
	/*
	N = Number of strings
	M = Length of the largest string
	O(NM log M)*/

	public static void main(String[] args) {
		String[] A = { "abcd", "abde", "abcf" };
		longestCommonPrefix(A);
	}

	public static String longestCommonPrefix(String[] A) {
		String minLengthString = findTheMinLengthString(A);
		int low = 0;
		int high = minLengthString.length() - 1;
		String prefix = "";

		while (low <= high) {
			int mid = low + (high - low) / 2;
			boolean isCommon = isCommonString(A, minLengthString, low, mid);
			if (isCommon) {
				prefix = prefix + minLengthString.substring(low, mid + 1);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(prefix);
		return prefix;
	}

	public static String findTheMinLengthString(String[] A) {
		String minLenghthStr = A[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i].length() < minLenghthStr.length())
				minLenghthStr = A[i];
		}
		return minLenghthStr;
	}

	public static boolean isCommonString(String[] A, String commonStr, int start, int end) {
		for (int i = 0; i < A.length; i++) {
			String curr = A[i];
			for (int j = start; j <= end; j++) {
				if (curr.charAt(j) != commonStr.charAt(j))
					return false;
			}
		}
		return true;
	}

}
