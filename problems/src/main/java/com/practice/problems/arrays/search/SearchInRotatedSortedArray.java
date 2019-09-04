package com.practice.problems.arrays.search;

import java.util.ArrayList;
import java.util.List;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(0);
		a.add(1);
		a.add(2);
		search(a, 4);
	}

	public static int search(List<Integer> a, int b) {
		int[] A = new int[a.size()];
		for (int i = 0; i < a.size(); i++)
			A[i] = a.get(i);
		return rotatedSortedArraySearch(A, 0, A.length - 1, b);
	}

	public static int rotatedSortedArraySearch(int[] A, int start, int end, int B) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2;
		if (A[mid] == B) {
			System.out.println(mid);
			return mid;
		}
		if (A[start] <= A[mid]) {
			if (B >= A[start] && B <= A[mid]) {
				return rotatedSortedArraySearch(A, start, mid - 1, B);
			} else {
				return rotatedSortedArraySearch(A, mid + 1, end, B);
			}
		}
		if (B >= A[mid] && B <= A[end]) {
			return rotatedSortedArraySearch(A, mid + 1, end, B);
		} else {
			return rotatedSortedArraySearch(A, start, mid - 1, B);
		}
	}

}
