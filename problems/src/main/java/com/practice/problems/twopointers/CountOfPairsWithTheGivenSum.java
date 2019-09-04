package com.practice.problems.twopointers;

public class CountOfPairsWithTheGivenSum {

	public static void main(String[] args) {
		int[] B = { 1, 2, 3, 4, 5 }; // 2
		int L = 5;

		int[] C = { 5, 10, 20, 100, 105 }; // 2
		int M = 110;

		int[] A = { 1, 2, 4, 5, 7, 8, 9, 15 };
		int K = 10;

		int i = 0;
		int j = A.length - 1;

		int count = 0;
		while (i < j) {
			if ((A[i] + A[j]) > K) {
				j--;
			} else if ((A[i] + A[j]) < K) {
				i++;
			} else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println("Count:::" + count);
	}

}
