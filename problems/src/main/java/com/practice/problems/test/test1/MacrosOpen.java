package com.practice.problems.test.test1;

import java.util.Arrays;
import java.util.Stack;

public class MacrosOpen {

	public static void main(String[] args) {
		String[] A = { "pii", "ppiipii", "ppiii", "ii", "p", "piii", "pp", "pii", "sii" };
		String[] ans = macrosOpen(A);
		System.out.println("Ans::" + Arrays.toString(ans));

	}

	public static String[] macrosOpen(String[] A) {
		String[] ans = new String[A.length];

		for (int i = 0; i < A.length; i++) {
			String s = A[i];
			String pair = pair(s);
			ans[i] = pair;
		}
		return ans;
	}

	public static String pair(String s) {
		String ans = null;
		int strLenght = s.length() - 1;

		Stack<String> stack = new Stack<>();
		for (int i = strLenght; i >= 0; i--) {
			char c = s.charAt(i);
			String sc = String.valueOf(c);
			if (!sc.equalsIgnoreCase("p")) {
				stack.push(sc);
			} else {
				String str = new String();
				str += "pair(";
				if (!stack.isEmpty()) {
					String val1 = stack.pop();
					if (val1.equalsIgnoreCase("i")) {
						val1 = "Integer";
					}
					str += val1 + ",";
					if (!stack.isEmpty()) {
						String val2 = stack.pop();
						if (val2.equalsIgnoreCase("i")) {
							val2 = "Integer";
						}
						str += val2 + ")";
					} else {
						return "-1";
					}
				} else {
					return "-1";
				}
				stack.push(str);
			}
		}
		if (stack.isEmpty())
			return "-1";
		else {
			ans = stack.pop();
		}

		if (!stack.isEmpty())
			return "-1";
		return ans;
	}
}
