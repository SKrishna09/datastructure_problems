package com.practice.problems.arrays.search;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();

		x.add(new ArrayList<Integer>(Arrays.asList(22, 32, 67)));
		/*x.add(new ArrayList<Integer>(Arrays.asList(32, 34, 35, 36, 37, 40, 41, 44, 44, 44)));
		x.add(new ArrayList<Integer>(Arrays.asList(29, 32, 32, 32, 33, 34, 34, 34, 35, 40)));
		x.add(new ArrayList<Integer>(Arrays.asList(40, 42, 42, 43, 44, 46, 46, 47, 47, 47)));
		x.add(new ArrayList<Integer>(Arrays.asList(48, 48, 48, 50, 51, 51, 51, 51, 51, 52)));
		x.add(new ArrayList<Integer>(Arrays.asList(82, 83, 83, 84, 84, 85, 86, 88, 89, 91)));
		x.add(new ArrayList<Integer>(Arrays.asList(91, 91, 95, 95, 96, 96, 97, 99, 100, 100)));*/
		searchMatrix(x, 93);

	}

	public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int elementFound = 0;
		int m = a.size();
		int n = a.get(0).size();
		int[][] A = new int[m][n];

		for (int i = 0; i < m; i++) {
			ArrayList<Integer> column = a.get(i);
			for (int j = 0; j < n; j++) {
				int value = column.get(j);
				A[i][j] = value;
			}
		}

		int low = 0;
		int high = m;

		int row = 0;
		while (low < high) {
			int mid = low + (high - low) / 2;

			int lowValue = A[mid][0];
			int highValue = A[mid][n - 1];
			if (b < lowValue) {
				high = mid - 1;
			} else if (b >= lowValue && b <= highValue) {
				low = mid;
				break;
			} else {
				low = mid + 1;
			}
		}
		row = low;
		if (row > m - 1) {
			System.out.println(elementFound);
			return elementFound;
		}

		int nlow = 0;
		int nhigh = n - 1;

		while (nlow < nhigh) {
			int mid = nlow + (nhigh - nlow) / 2;

			int midValue = A[row][mid];	

			if (b == midValue) {
				elementFound = 1;
				break;
			}
			if (b > midValue) {
				nlow = mid + 1;
			} else {
				nhigh = mid - 1;
			}
		}
		System.out.println(elementFound);
		return elementFound;
	}

}
