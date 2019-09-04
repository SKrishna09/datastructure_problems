package com.practice.problems.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseTheFirstKElements {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6 };
		int B = 3;
		System.out.println("Given Array:::" + Arrays.toString(A));
		int[] ans = reverseTheFirstKElements(A, B);
		System.out.println("Arrays after reversing K elements:::" + Arrays.toString(ans));

	}

	public static int[] reverseTheFirstKElements(int[] A, int B) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < B; i++) {
			q.add(A[i]);
		}
		int i = B - 1;
		while (!q.isEmpty()) {
			A[i] = q.poll();
			i--;
		}
		return A;
	}

}
