package com.practice.problems.stack;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		int[] A = { 2, 1, 5, 6, 2, 3 };
		int area = largestRectangleArea(A);
		System.out.println("LargestRectangleinHistogram:::" + area);
	}

	public static int largestRectangleArea(int[] A) {
		int index = A[0];
		int value = A[0];
		int area = Math.max(Integer.MIN_VALUE,value);

		for (int i = 1; i < A.length; i++) {
			int val = A[i];
			if (val > value) {
				area = Math.max(area, (value) * ((i - index) + 1));
				index = i;
				value = val;
			}
		}
		return area;
	}

}
