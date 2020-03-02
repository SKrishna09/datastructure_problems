package com.practice.problems.twopointers;

import java.util.Arrays;
import java.util.TreeSet;

public class SmallestSequenceWithGivenPrimes {

	public static void main(String[] args) {
		int A = 2;
		int B = 3;
		int C = 5;
		int D = 5;
		System.out.println("SmallestSequenceWithGivenPrimes:::" + Arrays.toString(solve(A, B, C, D)));
	}

	public static int[] solve(int A, int B, int C, int D) {
		int[] answer = new int[D];

		int count = 0;
		TreeSet<Integer> set = new TreeSet<>();
		set.add(A);
		set.add(B);
		set.add(C);
		while (count < D) {
			int current = set.first();
			set.remove(current);
			answer[count++] = current;
			if (count == D)
				break;
			set.add(current * A);
			set.add(current * B);
			set.add(current * C);
		}
		return answer;
	}

}
