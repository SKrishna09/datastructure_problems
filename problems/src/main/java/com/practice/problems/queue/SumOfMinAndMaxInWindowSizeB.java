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
		Deque<Integer> qmin = new LinkedList<>();
		Deque<Integer> qmax = new LinkedList<>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int i;
		for (i = 0; i < B; i++) {
			if (A[i] < min) {
				qmin.add(i);
				min = A[i];
				max = A[i];
			}
			if (A[i] > max) {
				qmax.add(i);
				max = A[i];
			}
		}
		for (; i < N; i++) {
			int minValue = 0;
			Integer topMinIndex = qmin.peek();
			if (null != topMinIndex)
				minValue = A[topMinIndex];

			int maxValue = 0;
			Integer topMaxIndex = qmax.peek();
			if (null != topMaxIndex)
				maxValue = A[topMaxIndex];

			sum = minValue + maxValue;

			Integer index = qmin.peek();
			if (null != index && index <= (i - B)) {
				qmin.removeFirst();
			}

			Integer index1 = qmax.peek();
			if (null != index1 && index1 <= (i - B)) {
				qmax.removeFirst();
			}

			if (A[i] < min) {
				qmin.add(i);
				min = A[i];
			}
			if (A[i] > max) {
				qmax.add(i);
				max = A[i];
			}
		}
		return sum;
	}

}
