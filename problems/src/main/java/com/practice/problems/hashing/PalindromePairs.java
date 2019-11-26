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
		String[] A = {"abcd", "dcba", "lls", "s", "sssll"};
		solve(Arrays.asList(A));
	}
	
	public static List<ArrayList<Integer>> solve(List<String> A) {
		Map<String,Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		int i = 0;
		for(String str1 : A) {
			map.put(str1, i++);
			list.add(str1);
		}
		
		for(String str2 : A) {
			
		}
		
		return null;
    }

}
