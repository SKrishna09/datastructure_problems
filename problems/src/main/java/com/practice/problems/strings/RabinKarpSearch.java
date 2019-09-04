package com.practice.problems.strings;

public class RabinKarpSearch {

	public static void main(String[] args) {
		String text = "AABAACAADAABAABA";
		String pattern = "AABA";
		int q = 121;
		rabinKarpPatternSearching(text, pattern, q);
	}

	public static void rabinKarpPatternSearching(String text, String pattern, int q) {
		int d = 256;
		int m = text.length();
		int n = pattern.length();
		int p = 0;
		int t = 0;
		int h = 1;

		for (int i = 0; i < n - 1; i++) {
			h = (h * d) % q;
		}

		for (int i = 0; i < n; i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}

		for (int i = 0; i <= (m - n); i++) {
			if (p == t) {
				int j;
				for (j = 0; j < n; j++) {
					if (text.charAt(i + j) != pattern.charAt(j))
						break;
				}
				if (j == n)
					System.out.println("Pattern found at " + i);
			}
			if (i < (m - n)) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + n)) % q;
				if (t < 0)
					t = (t + q);
			}
		}

	}

}
