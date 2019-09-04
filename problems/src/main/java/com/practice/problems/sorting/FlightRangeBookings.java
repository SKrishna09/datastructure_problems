package com.practice.problems.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class FlightRangeBookings {

	public static void main(String[] args) {
		int A = 5;
		int[][] B = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
		solve(A, B);
		ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
		x.add(new ArrayList<Integer>(Arrays.asList(1, 1, 5)));
		x.add(new ArrayList<Integer>(Arrays.asList(2, 2, 5)));
		x.add(new ArrayList<Integer>(Arrays.asList(3, 4, 5)));
		x.add(new ArrayList<Integer>(Arrays.asList(5, 5, 5)));
		solve1(A, x);
	}

	public static int[] solve(int A, int[][] B) {
		int[] result = new int[A];
		int m = B.length;
		int n = B[0].length;

		if (m > 0 && n > 0) {
			for (int i = 0; i < m; i++) {
				int start = B[i][0];
				int end = B[i][1];
				int seats = B[i][2];
				for (int j = start; j <= end; j++) {
					result[j - 1] += seats;
				}
			}
		}
		System.out.println("Result:::" + Arrays.toString(result));
		return result;
	}

	public static ArrayList<Integer> solve1(int A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		int[] result = new int[A];
		int n = B.size();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> inner = B.get(i);
			int innerSize = inner.size();
			if (innerSize > 0) {
				int start = inner.get(0);
				int end = inner.get(1);
				int seats = inner.get(2);
				for (int j = start; j <= end; j++) {
					result[j - 1] += seats;
				}
			}
		}
		for (int i = 0; i < A; i++) {
			arr.add(result[i]);
		}
		return arr;
	}
}
