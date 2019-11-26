package com.practice.problems.arrays.search;

public class FindAPeakElement {
	
	/*Find a peak element
	Given an array of integers A, find and return the peak element in it.
	An array element is peak if it is NOT smaller than its neighbors.
	For corner elements, we need to consider only one neighbor.
	For example, for input array {5, 10, 20, 15}, 20 is the only peak element.
	
	Following corner cases give better idea about the problem.
	1) If input array is sorted in strictly increasing order, the last element is always a peak element. 
	For example, 5 is peak element in {1, 2, 3, 4, 5}.
	2) If input array is sorted in strictly decreasing order, the first element is always a peak element. 
	10 is the peak element in {10, 9, 8, 7, 6}.
	
	Input 1:
	    A = [1, 2, 3, 4, 5]
	Output 1:
	    5

	Input 2:
	    A = [5, 17, 100, 11]
	Output 2:
	    100*/
	
	public static void main(String[] args) {
		int[] A = { 5, 17, 100, 11 };
		int peak = solve(A);
		System.out.println("Peak Value is::" + peak);
	}

	public static int solve(int[] A) {
		int length = A.length - 1;
		int low = 0;
		int high = length;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || A[mid] >= A[mid - 1]) && (mid == length || A[mid] >= A[mid + 1])) {
				return A[mid];
			} else {
				if (A[mid + 1] > A[mid])
					low = mid + 1;
				if (A[mid - 1] > A[mid])
					high = mid - 1;
			}
		}
		if (low == high)
			return A[low];
		else
			return -1;
	}

}
