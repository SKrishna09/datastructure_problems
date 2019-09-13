package com.practice.problems.test.test1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctColors {

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 3, 4, 3 };
		int B = 3;
		int[] ans = distinctColors(A, B);
		System.out.println("Distinct Colors:::" + Arrays.toString(ans));
	}

	private static int[] distinctColors(int[] A, int B) {
		int[] ans = new int[A.length - B + 1];
		Set<Integer> set = new HashSet<>();
		int i = 0;
		while (i <= A.length - B) {
			int j = i;
			int val = B;
			int count = 0;
			while (count < val) {
				set.add(A[j]);
				j++;
				count++;
			}
			ans[i] = set.size();
			set = new HashSet<>();
			i++;
		}
		return ans;
	}
}
