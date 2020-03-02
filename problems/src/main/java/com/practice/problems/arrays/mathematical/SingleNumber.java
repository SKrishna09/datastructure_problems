package com.practice.problems.arrays.mathematical;

public class SingleNumber {
	/*Single Number
	Given an array of integers, every element appears twice except for one. 
	Find that single one.
	Note: Your algorithm should have a linear runtime complexity.
	Could you implement it without using extra memory?
			Example Input 1:
			    A = [1, 2, 2, 3, 1]
			Example Output 1:
			    3
			Explanation:
			    3 occurs only once
			Example Input 2:
			    A = [1, 2, 2]
			Example Output 2:
			    1*/
	
	public static void main(String[] args) {
		int[] A = { 7, 3, 5, 4, 5, 3, 4 };
		System.out.println("Single Number::" + singleNumber(A));
	}

	// XOR
	/*Since XOR is associative and commutative, above 
	expression can be written as:
	res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5)  
	    = 7 ^ 0 ^ 0 ^ 0
	    = 7 ^ 0
	    = 7 */
	public static int singleNumber(final int[] A) {
		int val = A[0];
		for (int i = 1; i < A.length; i++) {
			val = val ^ A[i];
		}
		return val;
	}
}
