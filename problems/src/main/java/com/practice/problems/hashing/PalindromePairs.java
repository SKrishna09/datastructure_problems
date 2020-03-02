package com.practice.problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	
	/* Palindrome Pairs
	Given a list of unique words A, find all pairs of distinct indices (i,j) in the given list 
	such that concatenation of the two words, i.e. A[i] + A[j] is a palindrome.
	
	Note: A string is a palindrome if it reads the same backward as forward.
	Input Format
	The only argument given is the integer array A.
	Output Format
	Return the list of all pairs of distinct indices such that concatenation of the two words, i.e. A[i] + A[j] is a palindrome. 
	You can return the list in any order.
	
	Constraints
	1 <= length of the list A <= 1000
	100 <= length of words in list A <= 100		
			
			Input 1:
			    A = ["abcd", "dcba", "lls", "s", "sssll"]
			Output 1:
			    [ [0,1], [1,0], [3,2], [2,4] ] 

			Input 2:
			    A = ["abc", "sa", "xy", "as" ]
			Output 2:
			    [ [1,3], [3,1] ]		*/
	
	
	public static void main(String[] args) {
		String[] A = { "abcd", "dcba", "lls", "s", "sssll" };
		List<ArrayList<Integer>> res = solve(Arrays.asList(A));
		System.out.println(res.toString());
	}

	public static List<ArrayList<Integer>> solve(List<String> A) {
		List<ArrayList<Integer>> res = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++)
			map.put(A.get(i), i);

		for (int i = 0; i < A.size(); i++) {
			String str = A.get(i);

			for (int j = 0; j < str.length(); j++) {
				String str1 = str.substring(0, j);
				String str2 = str.substring(j);

				if (isPalindrome(str1)) {
					String revStr2 = new StringBuilder(str2).reverse().toString();
					if(map.containsKey(revStr2) && i != map.get(revStr2)) {
						ArrayList<Integer> ans = new ArrayList<>();
						ans.add(map.get(revStr2));
						ans.add(i);
						res.add(ans);
					}
				}

				if (isPalindrome(str2)) {
					String revStr1 = new StringBuilder(str1).reverse().toString();
					if(map.containsKey(revStr1) && i != map.get(revStr1)) {
						ArrayList<Integer> ans = new ArrayList<>();
						ans.add(map.get(revStr1));
						ans.add(i);
						res.add(ans);
					}
				}
			}
		}
		return res;
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
