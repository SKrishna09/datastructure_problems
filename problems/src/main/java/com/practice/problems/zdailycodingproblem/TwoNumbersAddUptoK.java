package com.practice.problems.zdailycodingproblem;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumbersAddUptoK {

	/*
	 * This problem was recently asked by Google. Given a list of numbers and a
	 * number k, return whether any two numbers from the list add up to k. For
	 * example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
	 */

	public static void main(String[] args) {
		int[] A = { 10, 15, 3, 7 };
		int K = 17;

		int B[] = { 1, 4, 45, 6, 10, -8 };
		boolean isPossible = twoNumbersAddUptoK(A, K);
		System.out.println("Two Numbers Added UpTo K is::" + isPossible);

		boolean isPossible1 = _twoNumbersAddUptoK(B, K);
		System.out.println("Two Numbers Added UpTo K is::" + isPossible1);
	}

	/*
	 * Depends on what sorting algorithm we use. If we use Merge Sort or Heap Sort
	 * then O(nlogn) in worst case. If we use Quick Sort then O(n^2) in worst case.
	 */

	// SORTING
	private static boolean twoNumbersAddUptoK(int[] A, int K) {
		Arrays.sort(A);
		int i = 0;
		int j = A.length - 1;
		while (i < j) {
			int val1 = A[i];
			int val2 = A[j];

			if (val1 + val2 == K)
				return true;
			if (val1 + val2 < K)
				i++;
			else
				j--;
		}
		return false;
	}

	// HASHING - O(n)
	private static boolean _twoNumbersAddUptoK(int[] A, int K) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			int val = A[i];
			hs.add(val);

			int remain = K - val;

			if (hs.contains(remain))
				return true;
		}
		return false;
	}
}
