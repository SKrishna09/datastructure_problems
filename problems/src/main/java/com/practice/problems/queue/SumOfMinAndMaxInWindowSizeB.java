package com.practice.problems.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMinAndMaxInWindowSizeB {

	public static void main(String[] args) {
		int[] A = { -8, 2, 3, -6, 10 };
		int B = 3;
		int ans = sumOfMinAndMaxInWindowSizeB(A, B);
		System.out.println(ans);
	}

	public static int sumOfMinAndMaxInWindowSizeB(int[] A, int B) {
		int sum = 0;
		int N = A.length;
		Deque<Integer> qmin = new LinkedList<Integer>();
		Deque<Integer> qmax = new LinkedList<Integer>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < B; i++) {
			if (A[i] < min) {
				qmin.removeFirst();
				qmin.add(i);
				min = A[i];
			}
			if (A[i] > max) {
				qmax.removeFirst();
				qmax.add(i);
				max = A[i];
			}
		}
		return sum;
	}

}
