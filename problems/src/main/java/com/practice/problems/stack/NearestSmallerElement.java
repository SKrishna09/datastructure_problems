package com.practice.problems.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

	public static void main(String[] args) {
		int[] A = { 4, 5, 2, 10, 8 };
		int[] ans = prevSmaller(A);
		System.out.println("NearestSmallerElement:::" + Arrays.toString(ans));
		System.out.println("NearestSmallerElement:::" + Arrays.toString(A));
	}

	public static int[] prevSmaller(int[] A) {
		int[] ans = new int[A.length];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < A.length; i++) {
			int val = A[i];
			while (!st.isEmpty()) {
				int val1 = st.peek();
				if (val1 < val) {
					A[i] = val1;
					ans[i] = val1;
					st.push(val);
					break;
				} else {
					st.pop();
				}
			}
			if (st.isEmpty()) {
				A[i] = -1;
				ans[i] = -1;
				st.push(val);
			}
		}
		return ans;
	}
}
