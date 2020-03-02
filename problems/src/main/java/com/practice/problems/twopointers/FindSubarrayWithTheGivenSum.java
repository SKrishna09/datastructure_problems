package com.practice.problems.twopointers;

import java.util.Arrays;

public class FindSubarrayWithTheGivenSum {
	
	/*
	 * Find sub-array with the given sum:::::
	 * Given an array of positive integers A and
	 * an integer B, find and return first continuous sub array which adds to B. If
	 * the answer does not exist return an array with a single element "-1".
	 * A = [1, 2, 3, 4, 5] 
	 * B = 5
	 */

	public static void main(String[] args) {
		int[] A = { 5, 10, 20, 100, 105 };
		int B = 110;

		System.out.println(Arrays.toString(eff_solution(A, B)));
		System.out.println(Arrays.toString(solution(A, B)));
	}

	public static int[] eff_solution(int[] a, int b) {
		long sum = 0;
		int i = 0;
		for (int j = 0; j < a.length; j++) {
			sum += a[j];
			while (sum > b)
				sum -= a[i++];
			if (sum == b) {
				int[] ans = new int[j - i + 1];
				int l = 0;
				for (int k = i; k <= j; k++) {
					ans[l++] = a[k];
				}
				return ans;
			}
		}
		return new int[] { -1 };
	}

	public static int[] solution(int[] A, int B) {
		int len = A.length;

		int startIndex = -1;
		int endIndex = -1;

		int sum = 0;
		Outer: for (int i = 0; i < len; i++) {
			sum = A[i];
			for (int j = i + 1; j <= len; j++) {
				if (sum == B) {
					startIndex = i;
					endIndex = j - 1;
					System.out.println("SubArray From::" + i + " to " + (j - 1));
					break Outer;
				}
				if (sum > B || j == len)
					break;
				sum += A[j];
			}
		}

		int[] answer;
		if (startIndex > 0 && endIndex > 0) {
			answer = new int[(endIndex - startIndex) + 1];
			int x = 0;
			for (int k = startIndex; k <= endIndex; k++) {
				answer[x++] = A[k];
			}
		} else {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}

}
