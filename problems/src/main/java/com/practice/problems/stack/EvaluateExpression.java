package com.practice.problems.stack;

import java.util.Stack;

public class EvaluateExpression {

	public static void main(String[] args) {
		String[] A = { "2", "1", "+", "3", "*" };
		int answer = evalRPN(A);
		System.out.println(answer);
	}

	public static int evalRPN(String[] A) {
		int ans = Integer.MIN_VALUE;
		String operator = "+-*/";
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < A.length; i++) {
			String val = A[i];
			if (!operator.contains(val))
				st.push(Integer.parseInt(val));
			else {
				Integer opr1;
				Integer opr2;
				if (!st.isEmpty()) {
					opr1 = st.pop();
					opr2 = st.pop();
					int answer = evaluate(opr2, opr1, val);
					ans = answer;
					st.push(answer);
				}
			}
		}
		return ans;
	}

	public static int evaluate(int a, int b, String c) {
		if (c.equals("+"))
			return a + b;
		if (c.equals("-"))
			return a - b;
		if (c.equals("*"))
			return a * b;
		if (c.equals("/"))
			return a / b;
		return 0;
	}

}
