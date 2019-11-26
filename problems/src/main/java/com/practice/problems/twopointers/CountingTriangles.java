package com.practice.problems.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountingTriangles {
	
	/*Counting Triangles
	You are given an array of N non-negative integers, A0, A1 ,..., AN-1. 
	Considering each array element Ai as the edge length of some line segment, 
	count the number of triangles which you can form using these array values. 
	Notes:
	You can use any value only once while forming each triangle.
	Order of choosing the edge lengths doesn't matter. Any triangle formed should have a positive area.
	A = [1, 1, 1, 2, 2]
	Return: 4*/

	public static void main(String[] args) {
		Integer[] A = { 1, 1, 1, 2, 2 };
		nTriang(Arrays.asList(A));
	}

	public static int nTriang(List<Integer> A) {
		int n = A.size();
		int res = 0;
		if (n < 3)
			return res;
		int mod = 1000000007;
		Collections.sort(A);

		for (int i = n - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k) {
				long sum = A.get(j) + A.get(k);
				if (sum > A.get(i)) {
					res = (res + (k - j) % mod) % mod;
					k--;
				} else {
					j++;
				}
			}
		}
		System.out.println("Triangles:::" + res);
		return res;
	}
}
