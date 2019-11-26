package com.practice.problems.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	/*Longest Consecutive Sequence
	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
	Example: 
	Given [100, 4, 200, 1, 3, 2], 
	The longest consecutive elements sequence is [1, 2, 3, 4]. 
	Return its length: 4. 
	Your algorithm should run in O(n) complexity.*/
	
	public static void main(String[] args) {
		int[] A = { 100, 4, 200, 1, 3, 2 };
		int length = longestConsecutiveSequence(A);
		System.out.println("LongestConsecutiveSequence length for 100, 4, 200, 1, 3, 2 is ::" + length);
		
		int length1 = _longestConsecutiveSequence(A);
		System.out.println("_LongestConsecutiveSequence length for 100, 4, 200, 1, 3, 2 is ::" + length1);
	}

	public static int longestConsecutiveSequence(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();

		int ans = -1;
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i])) {
				int length1 = map.containsKey(A[i] - 1) ? map.get(A[i] - 1) : 0;
				int length2 = map.containsKey(A[i] + 1) ? map.get(A[i] + 1) : 0;
				int st = 1 + length1 + length2;
				ans = Math.max(ans, st);
				map.put(A[i] - length1, st);
				map.put(A[i] + length2, st);
			}
		}
		return ans;
	}
	
	public static int _longestConsecutiveSequence(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++)
			map.put(A[i], i);

		int ans = -1;
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i] - 1)) {
				int lenght = 0;
				int val = A[i];
				while (map.containsKey(val)) {
					lenght++;
					val++;
				}

				ans = Math.max(ans, lenght);
			}
		}
		return ans;
	}
}
