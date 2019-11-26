package com.practice.problems.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {
	
	/*Largest Continuous Sequence Zero Sum
	Find the largest continuous sequence in a array which sums to zero. 
	Example:
	Input:  {1 ,2 ,-2 ,4 ,-4}
	Output: {2 ,-2 ,4 ,-4}	*/

	public static void main(String[] args) {
		Integer[] A = { 1, 2, -2, 4, -4 };
		lszero(Arrays.asList(A));
	}

	public static List<Integer> lszero(List<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int k = 0;
		int l = 0;
		Integer ps = 0;
		for (int i = 0; i < A.size(); i++) {
			ps += A.get(i);
			if (map.containsKey(ps)) {
				if (i - map.get(ps) > l - k) {
					k = map.get(ps);
					l = i;
				}
			} else {
				map.put(ps, i);
			}
		}
		for (int i = k + 1; i <= l; i++) {
			result.add(A.get(i));
		}
		System.out.println("LargestContinuousSequenceZeroSum" + result.toString());
		return result;
	}

}
