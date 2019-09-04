package com.practice.problems.sorting;

public class ReversePairsInversionCount {

	/*Given an array of integers A.
	If i< j and A[i]>A[j]
	then the
	pair (i, j) is called an inversion of A.
	Find the total number of inversions of A modulo (10^9 + 7).*/

	public static int count = 0;

	public static void main(String[] args) {
		int[] A = { 1, 2, 5, 4, 3 }; // 3
		int[] B = { 5, 17, 100, 11 }; // 1
		solve(A);
	}

	public static void solve(int[] A) {
		int[] temp = new int[A.length];
		mergeSort(A, temp, 0, A.length - 1);
		System.out.println("Count:::" + count);
	}

	public static void mergeSort(int[] A, int[] temp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(A, temp, left, mid);
			mergeSort(A, temp, mid + 1, right);
			merge(A, temp, left, mid, mid + 1, right);
		}
	}

	public static void merge(int[] A, int[] temp, int left, int mid, int midd, int right) {
		int i = left;
		int j = midd;
		int k = left;
		while ((i <= mid) && (j <= right)) {
			if (A[i] <= A[j]) {
				temp[k] = A[i];
				k++;
				i++;
			} else {
				temp[k] = A[j];
				k++;
				j++;
				count += midd - i;
			}
		}
		while (i <= mid) {
			temp[k] = A[i];
			k++;
			i++;
		}
		while (j <= right) {
			temp[k] = A[j];
			k++;
			j++;
		}
		for (int x = left; x <= right; x++) {
			A[x] = temp[x];
		}
	}
}
