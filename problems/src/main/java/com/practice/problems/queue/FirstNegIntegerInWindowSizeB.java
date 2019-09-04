package com.practice.problems.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegIntegerInWindowSizeB {

	public static void main(String[] args) {
		int[] A = { -8, 2, 3, -6, 10 };
		int B = 3;
		int[] ans = firstNegIntegerInWindowSizeB(A, B);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] firstNegIntegerInWindowSizeB(int[] A, int B) {
		int N = A.length;
		int[] ans = new int[N + 1 - B];

		Deque<Integer> q = new LinkedList<Integer>();
		int i;
		int k = 0;
		for (i = 0; i < B; i++) {
			if (A[i] < 0)
				q.add(i);
		}
		for (; i < N; i++) {
			int value = 0;
			Integer topIndex = q.peek();
			if (null != topIndex)
				value = A[topIndex];
			ans[k++] = value;

			Integer index = q.peek();
			if (null != index && index <= (i - B)) {
				q.removeFirst();
			}

			if (A[i] < 0)
				q.add(i);
		}
		int value = 0;
		Integer topIndex = q.peek();
		if (null != topIndex)
			value = A[topIndex];
		ans[k++] = value;
		return ans;
	}

}
