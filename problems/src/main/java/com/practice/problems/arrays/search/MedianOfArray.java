package com.practice.problems.arrays.search;

import java.util.ArrayList;
import java.util.List;

public class MedianOfArray {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		/*
		 * A.add(1); A.add(4); A.add(5);
		 */
		/*
		 * A.add(-50); A.add(-41); A.add(-40); A.add(-19); A.add(5); A.add(21);
		 * A.add(28);
		 */
		/*
		 * A.add(-49); A.add(33); A.add(35); A.add(42);
		 */
		List<Integer> B = new ArrayList<Integer>();
		/*
		 * B.add(2); B.add(3);
		 */
		/*
		 * B.add(-50); B.add(-21); B.add(-10);
		 */
		B.add(0);
		B.add(23);
		Double ans = findMedianSortedArrays(A, B);
		System.out.println("Median::" + ans);
	}

	public static Double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		Integer aLength = a.size();
		Integer bLength = b.size();
		Integer median = (aLength + bLength) / 2;
		System.out.println(median);

		int[] ans = new int[aLength + bLength];

		int aPointer = 0;
		int bPointer = 0;

		int i = 0;
		while (aPointer < aLength && bPointer < bLength) {
			int aVal = a.get(aPointer);
			int bVal = b.get(bPointer);

			if (aVal < bVal) {
				ans[i] = aVal;
				aPointer++;
			} else {
				ans[i] = bVal;
				bPointer++;
			}
			if (0 == median)
				return median(ans, i, aLength + bLength);
			i++;
			median--;
		}
		while (aPointer < aLength) {
			int aVal = a.get(aPointer);
			ans[i] = aVal;
			aPointer++;
			if (0 == median)
				return median(ans, i, aLength + bLength);
			i++;
			median--;
		}
		while (bPointer < bLength) {
			int bVal = b.get(bPointer);
			ans[i] = bVal;
			bPointer++;
			if (0 == median)
				return median(ans, i, aLength + bLength);
			i++;
			median--;
		}

		return 0d;
	}

	public static double median(int[] a, Integer index, Integer length) {
		if (length % 2 == 1) {
			return Double.valueOf(a[index]);
		} else {
			return ((double) a[index - 1] + (double) a[index]) / 2;
		}
	}
}
