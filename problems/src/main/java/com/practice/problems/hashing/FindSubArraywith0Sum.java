package com.practice.problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindSubArraywith0Sum {
	
	/*Find if there is a sub-array with 0 sum
	Given an array of integers A, find and return whether the given array contains a subarray 
	with a sum equal to 0. 
	If the given array contains a sub-array with sum zero return 1 else return 0.
	The only argument given is the integer array A.		
	Input 1:
	    A = [1, 2, 3, 4, 5]
	Output 1:
	    0

	Input 2:
	    A = [5, 17, -22, 11]
	Output 2:
	    1*/
	
	public static void main(String[] args) {
		int[] A = { 5, 17, -22, 11 };
		int val = subArray(A);
		String message = val == 0 ? "SubArray does not Exist" : "SubArray Exist";
		System.out.println(message);
	}

	public static int subArray(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		Integer ps = 0;
		for (int i = 0; i < A.length; i++) {
			ps += A[i];
			if (map.containsKey(ps))
				return 1;
			else
				map.put(ps, i);
		}
		return 0;
	}
}
