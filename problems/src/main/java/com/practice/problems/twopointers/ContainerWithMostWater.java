package com.practice.problems.twopointers;

public class ContainerWithMostWater {
	
	public static void main(String[] args) {
		int[] A = { 1, 5, 4, 3 };
		maxArea(A);
	}

	public static int maxArea(int[] A) {
		int maxArea = 0;

		int i = 0;
		int j = A.length - 1;

		while (i < j) {
			maxArea = Math.max(maxArea, ((j - i) * Math.min(A[i], A[j])));
			if (A[i] < A[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}

}
