package com.practice.problems.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharInStreamOfChar {

	static final int NO_OF_CHARS = 256;

	public static void main(String[] args) {
		String A = "abadbc"; // aabbdd
		String B = "abcabc"; // aaabc#
		System.out.println("GivenString:::" + A);
		String ans = firstNonRepeatingCharInStreamOfChar(A);
		System.out.println(ans);
		System.out.println();
		System.out.println("GivenString:::" + B);
		String ans1 = firstNonRepeatingCharInStreamOfChar(B);
		System.out.println(ans1);
	}

	public static String firstNonRepeatingCharInStreamOfChar(String A) {
		String ans = new String();

		int[] alphabet = new int[NO_OF_CHARS];
		Queue<Character> q = new LinkedList<>();

		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			alphabet[c]++;

			if (alphabet[c] == 1)
				q.add(c);

			while (!q.isEmpty()) {
				char qc = q.peek();
				if (alphabet[qc] == 1) {
					ans += qc;
					break;
				} else {
					q.remove();
				}
			}
			if (q.isEmpty())
				ans += "#";
		}
		return ans;
	}

}
