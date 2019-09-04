package com.practice.problems.backtracking;

import java.util.ArrayList;

public class AllUniquePermutation {

	public static void main(String[] args) {
		int[] A = { 1, 1, 2 };
		permute(A);
	}

	public static int[][] permute(int[] A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		_permute(A, 0, A.length - 1, result);
		int m = result.size();
		int n = result.get(0).size();
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> column = result.get(i);
			for (int j = 0; j < n; j++) {
				int value = column.get(j);
				arr[i][j] = value;
			}
		}
		return arr;
	}

	public static void _permute(int[] A, int start, int end, ArrayList<ArrayList<Integer>> result) {
		if (start == end) {
			ArrayList<Integer> lis = new ArrayList<>();
			for (int i : A) {
				lis.add(i);
			}
			result.add(lis);
			return;
		}
		for (int i = start; i <= end; i++) {
			boolean check = shouldSwap(A, start, i);
			if (check) {
				swap(A, start, i);
				_permute(A, start + 1, end, result);
				swap(A, start, i);
			}
		}
	}

	private static boolean shouldSwap(int[] a, int start, int curr) {
		for (int i = start; i < curr; i++) {
			if (a[i] == a[curr]) {
				return false;
			}
		}
		return true;
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
