package com.practice.problems.arrays.mathematical;

import java.util.Arrays;

public class RepeatAndMissingNumberArray {
	/*Multiple Ways::: https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/*/	
	
	/*Repeat and Missing Number Array
	You are given a read only array of n integers from 1 to n.
	Each integer appears exactly once except A which appears twice and B which is missing.
	Return A and B. Note: Your algorithm should have a linear runtime complexity.
	Could you implement it without using extra memory? Note that in your output A should precede B.
			Input:[3 1 2 5 3] 
			Output:[3, 4] 
			A = 3, B = 4		*/
	
	public static void main(String[] args) {
		int[] A = { 7, 3, 4, 5, 5, 6, 2 };
		System.out.println("Repeat and Missing Number Array::" + Arrays.toString(repeatedNumber(A)));
	}
	
	/*Traverse the array.
	While traversing, use the absolute value of every element as an index and make the value at this index 
	as negative to mark it visited.
	If something is already marked negative then this is the repeating element.
	To find missing, traverse the array again and look for a positive value.*/
	public static int[] repeatedNumber(final int[] A) {
		int[] ans = new int[2];

		for (int i = 0; i < A.length; i++) {
			int val = Math.abs(A[i]);
			if (A[val - 1] > 0) {
				A[val - 1] = -A[val - 1];
			} else {
				ans[0] = val;
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0)
				ans[1] = i+1;
		}
		return ans;
	}
}
