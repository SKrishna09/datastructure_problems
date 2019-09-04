package com.practice.problems.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContaining123 {

	public static void main(String[] args) {
		int A = 13;
		int[] ans = nIntegersContaining123(A);
		System.out.println("N integers containing only 1,2,3:::");
		System.out.println(Arrays.toString(ans));
	}

	public static int[] nIntegersContaining123(int A) {
		int[] ans = new int[A];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		for (int i = 0; i < A; i++) {
			int value = q.poll();
			ans[i] = value;
			q.add((value * 10) + 1);
			q.add((value * 10) + 2);
			q.add((value * 10) + 3);
		}
		return ans;
	}
}
