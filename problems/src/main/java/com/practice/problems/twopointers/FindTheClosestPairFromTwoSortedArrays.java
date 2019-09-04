package com.practice.problems.twopointers;

import java.util.Arrays;

public class FindTheClosestPairFromTwoSortedArrays {

	public static void main(String[] args) {

		int[] A = { 5, 10, 20 };
		int[] B = { 1, 2, 30 };
		int C = 13;
		solve(A, B, C);
	}

	public static int[] solve(int[] A, int[] B, int C) {
		int minimizedDifference = Integer.MAX_VALUE;
		int[] ans = new int[2];
		long startIndex = Integer.MAX_VALUE;
		long endIndex = Integer.MAX_VALUE;

		int i = 0;
		int j = B.length - 1;

		int l = A.length;

		while (i < l && j >= 0) {
			int val1 = A[i];
			int val2 = B[j];

			int diff = Math.abs((val1 + val2) - C);
			if (diff < minimizedDifference) {
				minimizedDifference = diff;
				startIndex = i;
				endIndex = j;

				if (diff == 0)
					break;
			}
			if (diff == minimizedDifference) {
				if ((i + j) < (startIndex + endIndex)) {
					startIndex = i;
					endIndex = j;
				}
			}
			if (val1 + val2 > C)
				j--;
			else
				i++;
		}

		if (startIndex >= 0 && endIndex >= 0)

		{
			ans[0] = A[(int) startIndex];
			ans[1] = B[(int) endIndex];
		}
		System.out.println("Ans:" + Arrays.toString(ans));
		return ans;
	}
}
