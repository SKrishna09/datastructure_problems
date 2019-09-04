package com.practice.problems.twopointers;

public class CountOfRectanglesWithAreaLessThanTheGivenNumber {

	public static void main(String[] args) {
		int[] A = { 10, 33, 40 };
		int B = 55;
		solve(A, B);
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
			count += ((j - i) * 2);
			if (A[i] * A[i] < B)
				count += 1;
		}
		System.out.println("Count:::" + count);
		return count;
	}

}
