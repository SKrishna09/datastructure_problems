package com.practice.problems.twopointers;

import java.util.Arrays;

public class FindSubarrayWithTheGivenSum {

	public static void main(String[] args) {
		int[] A = new int[1101];
		for (int i = 0; i < 1101; i++) {
			A[i] = i + 1;
		}
		int B = 500500;
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
		System.out.println(Arrays.toString(answer));
	}
}
