package com.practice.problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class DiffK {
	
	/*Difference k II
	Given an array A of integers and another non negative integer k, 
	find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
	Example : 
	Input :
	A : [1 5 3]
	k : 2
	Output :1
	as 3 - 1 = 2
	Return 0 / 1 for this problem.*/

	public static void main(String[] args) {
		int[] A = { 70,48,90 };
		int B = 70;
		int res = solve(A, B);
		String message = res == 1 ? "Difference Exist" : "Difference Not Exist";
		System.out.println(message);
	}

	public static int solve(int[] A, int B) {
		Map<Integer, Integer> map = new HashMap<>();
		if(B == 0)
			map.put(0, -1);
		for (int i = 0; i < A.length; i++)
			map.put(A[i], i);

		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			int val = A[i] - B;
			if (map.containsKey(val)) {
				int index = map.get(val);
				if (i != index) {
					ans = 1;
					return ans;
				}
			}
		}
		return ans;
	}
}
