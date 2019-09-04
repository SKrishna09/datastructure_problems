package com.practice.problems.arrays.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfAnArray {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 }; // ARRAY
		List<List<Integer>> result = new ArrayList<>();
		permutation(A, 0, A.length - 1, result);

		int m = result.size();
		int n = result.get(0).size();
		int[][] resultArr = new int[m][n];
		for (int i = 0; i < m; i++) {
			List<Integer> column = result.get(i);
			for (int j = 0; j < n; j++) {
				int value = column.get(j);
				resultArr[i][j] = value;
			}
		}
	}

	private static void permutation(int[] A, int start, int end, List<List<Integer>> result) {
		if (start == end) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int num : A) {
				list.add(num);
			}
			result.add(list);
			printArray(A);
			return;

		} else {
			for (int i = start; i <= end; i++) {
				swap(A, start, i);
				permutation(A, start + 1, end, result);
				swap(A, start, i);
			}
		}
	}

	private static void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	private static void printArray(int[] input) {
		System.out.print('\n');
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
	}
}
