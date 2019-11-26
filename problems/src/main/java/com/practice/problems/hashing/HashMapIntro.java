package com.practice.problems.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapIntro {

	public static void main(String[] args) {
		char[] A = { '+', '+', '?', '+' , '-' , '?' };
		String[] B = { "1", "241", "1", "361", "241", "101" };
		System.out.println(Arrays.toString(solve(A,B)));
	}

	public static int[] solve(char[] A, String[] B) {
		Map<String, Integer> map = new HashMap<>();
		int[] ans = new int[(A.length / 3)];
		int j = 0;

		int length = B.length;
		int i = 0;
		int count = 0;
		while (i < length) {
			int answerValue = 0;
			count++;
			char sym = A[i];
			String req = B[i];

			String val = decToBinary((Integer.valueOf(req)));

			if (sym == '+') {
				int v = 1;
				if (map.containsKey(val)) {
					v = map.get(val) + 1;
					map.put(val, v);
				} else {
					map.put(val, v);
				}
				answerValue = v;
			}
			if (sym == '-') {
				int x = 0;
				if (map.containsKey(val)) {
					x = map.get(val) - 1;
					map.put(val, x);
				}
				answerValue = x;
			}
			int qCount = 0;
			if (sym == '?') {
				int size = req.length();
				for (String key : map.keySet()) {
					if(key.length() >= size) {
					String subStr = key.substring(0, size);
					if (req.equals(subStr))
						qCount++;
					}
				}
				answerValue = qCount;
			}
			if (count % 3 == 0) {
				ans[j] = answerValue;
				j++;
			}
			i++;
		}
		return ans;
	}

	static String decToBinary(int n) {
		String ans = "";
		int[] binaryNum = new int[1000];

		int i = 0;
		while (n > 0) {
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}

		for (int j = i - 1; j >= 0; j--) {
			 ans += String.valueOf(binaryNum[j]);
		}
		return ans;
	}

}
