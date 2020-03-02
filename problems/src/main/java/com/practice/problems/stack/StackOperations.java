package com.practice.problems.stack;

public class StackOperations {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		pop();
		push(644643544);
		getMin();
		top();
		top();
		top();
		pop();
		push(723943208);
		pop();
		push(909204);
		getMin();
		top();
		getMin();
		top();
		push(481523691);
		pop();
		push(465865082);
		top();
		push(243519307);
		pop();
		top();
		pop();
		push(844871295);
		getMin();
		push(573041392);
		push(468497349);
		pop();
		top();
		getMin();
	}

	static int[] A = new int[100];
	static int i = -1;
	static int min;
	static int mod = 1000000007;

	public static void push(int x) {
		x = x % mod;
		if (i < A.length) {
			i++;
			if (x < min && i > 0) {
				min = x;
				int oldMin = min;
				x = (2 * x - oldMin) % mod;
			}
			A[i] = x;
			if (i == 0)
				min = A[i];
		}
	}

	public static void pop() {
		if (i >= 0) {
			if (A[i] < min) {
				min = (2 * min - A[i]) % mod;
			} else if (A[i] == min) {
				if (i > 0)
					min = A[i - 1];
				else
					min = -1;
			}
			A[i] = 0;
			i--;
		}
	}

	public static int top() {
		int value = -1;
		if (i >= 0) {
			if (A[i] < min) {
				value = min;
			} else {
				value = A[i];
			}
		}
		System.out.println("Top::" + value);
		return value;
	}

	public static int getMin() {
		System.out.println("Min::" + min);
		return Math.min(min, A[i]);
	}
}
