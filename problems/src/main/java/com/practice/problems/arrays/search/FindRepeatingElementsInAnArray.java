package com.practice.problems.arrays.search;

import java.util.Arrays;

public class FindRepeatingElementsInAnArray {

	public static void main(String[] args) {

		int[] A = { 0, 4, 3, 2, 7, 8, 2, 3, 1, 0 };
		System.out.println("Repeating elements are::::");
		findRepeatingElementsInAnArray(A);
	}

	public static void findRepeatingElementsInAnArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[A[i] % 10] = A[A[i] % 10] + 10;
		}
		System.out.println("Updated Array:::" + Arrays.toString(A));
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 19) {
				System.out.println(i + " ");
			}
		}
	}

}
