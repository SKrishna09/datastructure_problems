package com.practice.problems.sorting;

import java.util.Arrays;

public class MaximumDifference {
	public static void main(String[] args) {
		int[] A = { 70, 21, 7, 64, 44, 79, 50, 89, 68, 23, 20, 50, 65, 64, 48, 3, 46, 87 };
		solve(A, 16);
	}

	public static int solve(int[] A, int B) {
		Arrays.sort(A);
		int n = A.length;

		int sum1 = 0;
		int sum2 = 0;
		if (B <= n / 2) {
			for (int i = 0; i < B; i++)
				sum1 += A[i];
			for (int i = B; i < n; i++)
				sum2 += A[i];
		} else {
			B = n-B;
			for (int i = 0; i < B; i++)
				sum2 += A[i];
			for (int i = B; i < n; i++)
				sum1 += A[i];
		}
		return Math.abs(sum2 - sum1);
	}
}
