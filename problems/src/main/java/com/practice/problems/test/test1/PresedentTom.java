package com.practice.problems.test.test1;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PresedentTom {

	public static void main(String[] args) {

		int[] A = { 99, 77, 38, 89, 20, 73, 96, 31, 92, 96 };
		int sum = presedentTom(A, 35, 3); // 43
		System.out.println("SUM::" + sum);
	}

	public static int presedentTom(int[] A, int B, int C) {
		int sum = Integer.MAX_VALUE;
		while (B > 0) {
			Set<Integer> set = findMinAndLocation(A);
			List<Integer> l = null;
			if (set.size() > 1) {
				l = isUnderSameBucket(set, C);
			} else {
				l = new LinkedList<>(set);
			}
			int val = C / l.size();
			int min = 0;
			for (Integer li : l) {
				int count = 0;
				for (int i = li; count < val && i < A.length; i++) {
					A[i] = A[i] + 1;
					if (i == li)
						min = A[i];
					min = Math.min(min, A[i]);
					count++;
				}
			}
			sum = min;
			B--;
		}
		return sum;
	}

	public static List<Integer> isUnderSameBucket(Set<Integer> set, int C) {
		List<Integer> l = new LinkedList<Integer>();
		for (Integer i : set) {
			if (!set.contains(i - C))
				l.add(i);
		}
		return l;
	}

	public static Set<Integer> findMinAndLocation(int[] A) {
		Set<Integer> list = new LinkedHashSet<>();
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < min) {
				min = A[i];
				index = i;
			}
			if (min == A[i] && index != i) {
				list.add(index);
			}
		}
		list.add(index);
		return list;
	}
}
