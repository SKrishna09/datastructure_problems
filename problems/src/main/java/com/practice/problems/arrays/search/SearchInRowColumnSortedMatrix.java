package com.practice.problems.arrays.search;

public class SearchInRowColumnSortedMatrix {

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
		int B = 2;
		int value = solve(A, B);
		System.out.println(value);
	}

	public static int solve(int[][] A, int B) {
		int m = A.length;
		int n = A[0].length;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				int value = A[j][i];
				if (B < value)
					break;
				if (B == value)
					return ((j + 1) * 1009 + (i + 1));
			}
		}	
		return -1;
	}
}
