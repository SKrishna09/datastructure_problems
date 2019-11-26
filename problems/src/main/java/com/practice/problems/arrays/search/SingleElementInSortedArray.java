package com.practice.problems.arrays.search;

public class SingleElementInSortedArray {
	
	/*Single Element in a Sorted Array
	Given a sorted array of integers A where every element appears twice. 
	except for one element which appears once, find and return this single element that appears only once.
	Input Format
	The only argument given is the integer array A.
	
	Output Format
	Return the single element that appears only once.
	
	Constraints
	1 <= length of the array <= 100000
	1 <= A[i] <= 10^9 
			
	For Example
	Input 1:
	A = [1, 1, 2, 2, 3]
	Output 1:
	3

	Input 2:
	A = [5, 11, 11, 100, 100]
	Output 2:
	5		*/
	
	public static void main(String[] args) {
		int[] A = { 5, 5, 11, 11, 100, 100, 111, 115, 115 };
		System.out.println("SingleElementInSortedArray is:::" + solve(A));
	}

	public static int solve(int[] A) {
		int low = 0;
		int high = A.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;

			if (mid % 2 == 0) {
				if (A[mid] == A[mid + 1])
					low = mid + 2;
				else
					high = mid;

			} else if (mid % 2 == 1) {
				if (A[mid] == A[mid - 1])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		if (low == high)
			return A[low];
		else
			return -1;
	}
}
