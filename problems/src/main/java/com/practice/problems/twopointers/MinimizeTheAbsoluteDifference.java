package com.practice.problems.twopointers;

public class MinimizeTheAbsoluteDifference {

	public static void main(String[] args) {

		int[] A = { 1, 4, 5, 8, 10 };
		int[] B = { 6, 9, 15 };
		int[] C = { 2, 3, 6, 6 };
		solve(A, B, C);
	}

	public static int solve(int[] A, int[] B, int[] C) {
		int i = 0;
		int j = 0;
		int k = 0;
		int l = A.length;
		int m = B.length;
		int n = C.length;

		int minimizedDifference = Integer.MAX_VALUE;
		int min = 0;
		int max = 0;
		while (i < l && j < m && k < n) {
			int x = A[i];
			int y = B[j];
			int z = C[k];

			min = findMin(x, y, z);
			max = findMax(x, y, z);

			if(Math.abs((max - min)) < minimizedDifference)
				minimizedDifference = Math.abs((max - min));
			
			if (min == x) {
				i++;
			} else if (min == y) {
				j++;
			} else {
				k++;
			}
		}
		System.out.println("MinimizeTheAbsoluteDifference:::" + minimizedDifference);
		return minimizedDifference;
	}

	public static int findMin(int a, int b, int c) {
		int min = 0;
		min = Math.min(a, b);
		min = Math.min(c, min);
		return min;
	}

	public static int findMax(int a, int b, int c) {
		int max = 0;
		max = Math.max(a, b);
		max = Math.max(c, max);
		return max;
	}

}
