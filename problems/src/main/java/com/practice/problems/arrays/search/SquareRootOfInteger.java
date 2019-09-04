package com.practice.problems.arrays.search;

public class SquareRootOfInteger {
	
	private static final double SECURE_SQUARE_LIMIT = Math.sqrt(Integer.MAX_VALUE);
	public static void main(String[] args) {
		int a = 930675566;
		
		System.out.println(sqrt(a) % 1000000007);
	}

	public static int sqrt(int a) {
		if (0 == a)
			return a;
		if (a >= Integer.MAX_VALUE)
		    return 46340;

		int low = 1;
		int high = a;

		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			int val = mid * mid;
			if (val == a)
				return mid;

			if (mid * mid > a) {
				high = mid - 1;
			} else {
				low = mid + 1;
				ans = mid;
			}
		}
		return ans;
	}

}
