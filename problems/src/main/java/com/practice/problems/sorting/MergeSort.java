package com.practice.problems.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] A = { 2, 4, 5, 8, 1, 9, 3, 7 };
		int[] temp = new int[A.length];
		System.out.println("Before Sorting:::" + Arrays.toString(A));
		mergeSortAlgo(A, temp, 0, A.length - 1);
		System.out.println("After Sorting:::" + Arrays.toString(A));
	}

	public static void mergeSortAlgo(int[] A, int[] temp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSortAlgo(A, temp, left, mid);
			mergeSortAlgo(A, temp, mid + 1, right);
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
