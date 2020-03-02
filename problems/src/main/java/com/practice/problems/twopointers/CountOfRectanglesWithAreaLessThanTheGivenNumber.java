package com.practice.problems.twopointers;

public class CountOfRectanglesWithAreaLessThanTheGivenNumber {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int B = 5;
		solve(A, B);
		_solve(A, B);
		int count = __solve(A, B);
		System.out.println("CountOfRectanglesWithAreaLessThanTheGivenNumber is ::" + count);
	}

	public static int solve(int[] A, int B) {
		int count = 0;
		int i = 0;
		int j = A.length - 1;
		for (i = 0; i < A.length; i++) {
			while ((A[i] * A[j] >= B) && (j > i)) {
				j--;
			}
			if (j < i)
				break;
			count += 2 * (j - i);
			if (A[i] * A[i] < B)
				count += 1;
		}
		System.out.println("Count:::" + count);
		return count;
	}

	public static int _solve(int[] A, int B) {
		int count = 0;
		int i = 0;
		int j = A.length - 1;
		int k = j;
		for (i = 0; i <= k; i++) {
			while (i < j) {
				if ((A[i] * A[j]) >= B) {
					k--;
					j--;
				} else {
					count += 2;
					j--;
				}
			}
			if (A[i] * A[i] < B) {
				count += 1;
			}
			j = k;
		}
		System.out.println("Count:::" + count);
		return count;
	}

	public static int __solve(int[] a, int b) {
		long ans = 0;
		long mod = (long) (1e9 + 7);
		int l = 0;
		int r = a.length - 1;
		while (l < a.length && r >= 0) {
			if (1L * a[l] * a[r] < b) {
				ans = (ans + r + 1) % mod;
				l++;
			} else {
				r--;
			}
		}
		return (int) ans;
	}

}
