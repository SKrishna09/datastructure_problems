package com.practice.problems.sorting;

import java.util.Arrays;
import java.util.HashMap;

public class NumberOfSexTuplets {

	public static void main(String[] args) {
		int[] A = { 13, -25, 9, -27, -5, -23, 19, 1, -21, 25, 15, -29, -3, 21, 3, 23, -15, -17, -1, 0, -19, -11, -9, -7, 5, 17, -13, 11, 27, 7 };
		solve(A);
		findSextuplets(A, A.length);
	}

	public static int solve(int[] A) {
		int n = A.length;

		long[] rhsSum = new long[n * n * n + 1];
		int rhsSumi = 0;
		for (int i = 0; i < n; i++) {
			long d = A[i];
			if (d != 0) {
				for (int j = 0; j < n; j++) {
					long e = A[j];
					for (int k = 0; k < n; k++) {
						long f = A[k];
						rhsSum[rhsSumi++] = d * (f + e);
					}
				}
			}
		}

		HashMap<Long, Long> valueMap = new HashMap<>();
		for (int i = 0; i < rhsSum.length; i++) {
			Long value = 1l;
			if (valueMap.containsKey(rhsSum[i])) {
				value = valueMap.get(rhsSum[i]) + 1;
			}
			valueMap.put(rhsSum[i], value);
		}

		long count = 0;
		for (int i = 0; i < n; i++) {
			long a = A[i];
			for (int j = 0; j < n; j++) {
				long b = A[j];
				for (int k = 0; k < n; k++) {
					long c = A[k];
					long lhsSum = a * b + c;
					if (valueMap.containsKey(lhsSum))
						count += valueMap.get(lhsSum);
				}
			}
		}
		System.out.println("Map Method::" + count);
		return (int) (count % 100000007);
	}

	static int upper_bound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int lower_bound(int[] array, int length, int value) {
		int low = 0;
		int high = length;
		while (low < high) {
			final int mid = (low + high) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	static int findSextuplets(int[] arr, int n) {
		// Generating possible values of RHS of the equation
		int index = 0;
		int[] RHS = new int[n * n * n + 1];
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) // Checking d should be non-zero.
			{
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						RHS[index++] = arr[i] * (arr[j] + arr[k]);
					}
				}
			}
		}

		// Sort RHS[] so that we can do binary search in it.
		Arrays.sort(RHS);

		// Generating all possible values of LHS of the equation
		// and finding the number of occurances of the value in RHS.
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int val = arr[i] * arr[j] + arr[k];
					result += (upper_bound(RHS, index, val) - lower_bound(RHS, index, val));
				}
			}
		}
		System.out.println("Search Method::" + result);
		return result;
	}

}
