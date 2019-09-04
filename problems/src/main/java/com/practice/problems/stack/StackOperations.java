package com.practice.problems.stack;

public class StackOperations {

	int[] A = new int[10];
	int i = 0;

	public void push(int x) {
		if (i < A.length) {
			A[i++] = x;
		}
	}

	public void pop() {
		if (i >= 0) {
			A[i] = Integer.MIN_VALUE;
			i--;
		}
	}

	public int top() {
		int value = Integer.MIN_VALUE;
		if (i >= 0)
			value = A[i];
		return value;
	}

	public int getMin() {
		return 0;
	}
}
